package com.hr.mapper;

import com.hr.entity.AoaUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表数据层
 */
public interface IAoaUserMapper {

    public AoaUser login(@Param("userName") String userName, @Param("password") String password);

}