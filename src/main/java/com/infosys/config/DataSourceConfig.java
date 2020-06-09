package com.infosys.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
* 加载yml配置的数据源
* 
* @author Jiayoubing
* @version [版本号,2020年6月8日]
* @see [相关类/方法]
* @since [产品/模块版本]
 */
@Configuration
public class DataSourceConfig {

	// 创建可读数据源
	@Bean(name = "selectDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.select") // application.properteis中对应属性的前缀
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	// 创建可写数据源
	@Bean(name = "updateDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.update") // application.properteis中对应属性的前缀
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}

}
