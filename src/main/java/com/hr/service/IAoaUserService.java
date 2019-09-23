package com.hr.service;

import com.hr.entity.AoaUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
     * @param paramMap 参数集合
     * @return
     */
    public List<AoaUser> queryAoaUserForDirector(Map<String,Object> paramMap);

    /**
     * 获取通讯录总条目数
     *
     * @param paramMap 参数集合
     * @return
     */
    public Long getCountForDirector(Map<String, Object> paramMap);

    /**
     * 根据用户名查询用户ID
     *
     * @param userName 用户ID
     * @return
     */
    public Long queryAoaUserIdByUserName(@Param("userName") String userName);

}
