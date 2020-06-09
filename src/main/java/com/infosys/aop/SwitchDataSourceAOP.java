package com.infosys.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.infosys.config.DataSourceContextHolder;

@Aspect
@Component
@Lazy(false)//不使用延迟加载
@Order(0) // Order设定AOP执行顺序 使之在数据库事务上先执行,默认是最低优先级,值越小优先级越高
public class SwitchDataSourceAOP
{
    /**
     * 在执行server方法之前，先根据方法头来判断要做哪种类型的操作，来设置数据源
     * 
     * @param joinPoint[参数说明]
     * @return void[返回类型说明]
     * @exception throws
     *                [违例类型][违例说明]
     * @see [类、类#方法、类#成员]
     */

    @Before("execution(* com.infosys.service.*.*(..))")
    public void process(JoinPoint joinPoint)
    {
        String methodName = joinPoint.getSignature().getName();
        if (methodName.startsWith("get") || methodName.startsWith("count") || methodName.startsWith("find")
                || methodName.startsWith("list") || methodName.startsWith("select") || methodName.startsWith("check"))
        {
            // 读
            DataSourceContextHolder.setDbType("selectDataSource");
        }
        else
        {
            // 切换dataSource
            DataSourceContextHolder.setDbType("updateDataSource");
        }
    }
}
