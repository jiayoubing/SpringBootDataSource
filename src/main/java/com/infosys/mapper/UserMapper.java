package com.infosys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.infosys.entity.UserEntity;

public interface UserMapper
{
    @Select("SELECT * FROM  userinfo ")
    public List<UserEntity> findUser();

    @Select("insert into userinfo values (#{userName}); ")
    public List<UserEntity> insertUser(@Param("userName") String userName);
}
