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
     * 查询登陆用户的直属下属用户
     *
     * @param positionId 职位ID
     * @param deptId     部门ID
     * @return
     */
    public Long queryAoaUserForUnderstrapper(@Param("positionId") Long positionId, @Param("deptId") Long deptId);

    /**
     * 查询用户通讯录
     *
     * @param userId 用户ID
     * @return
     */
    public List<AoaUser> queryAoaUserForDirector(@Param("userId") Long userId);

    /**
     * 根据用户名查询用户ID
     *
     * @param userName 用户ID
     * @return
     */
    public Long queryAoaUserIdByUserName(@Param("userName") String userName);
}