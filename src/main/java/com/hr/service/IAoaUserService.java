package com.hr.service;

import com.hr.entity.AoaUser;

import java.util.List;

public interface IAoaUserService {

    public AoaUser login(String userName, String password);

    /**
     * 查询登陆用户的所有下属用户
     *
     * @param position_id
     * @return
     */
    public List<AoaUser> queryAoaUserByForUnderstrapper(Long position_id);
}
