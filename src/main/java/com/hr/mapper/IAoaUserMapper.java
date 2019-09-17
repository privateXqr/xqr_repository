package com.hr.mapper;

import com.hr.entity.AoaUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表数据层
 */
public interface IAoaUserMapper {

    /**
     * 登陆
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public AoaUser login(@Param("userName") String userName, @Param("password") String password);

}