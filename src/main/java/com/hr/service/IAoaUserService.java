package com.hr.service;

import com.hr.entity.AoaUser;

public interface IAoaUserService {

    public AoaUser login(String userName, String password);
}
