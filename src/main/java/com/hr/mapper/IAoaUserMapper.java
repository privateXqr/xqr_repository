package com.hr.mapper;

import com.hr.entity.AoaUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表数据层
 */
@Repository
public interface IAoaUserMapper {

    /**
     * 登陆
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    public AoaUser login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 查询登陆用户的所有下属用户
     *
     * @param position_id
     * @return
     */
    public List<AoaUser> queryAoaUserByForUnderstrapper(Long position_id);

}