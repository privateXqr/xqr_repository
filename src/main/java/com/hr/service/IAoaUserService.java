package com.hr.service;

import com.hr.entity.AoaUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAoaUserService {

    public AoaUser login(String userName, String password);

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
}
