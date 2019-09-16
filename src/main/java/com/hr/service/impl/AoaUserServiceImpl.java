package com.hr.service.impl;

import com.hr.entity.AoaUser;
import com.hr.mapper.IAoaUserMapper;
import com.hr.service.IAoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaUserServiceImpl implements IAoaUserService {

    @Autowired
    private IAoaUserMapper aoaUserMapper;

    @Override
    public AoaUser login(String userName, String password) {
        return aoaUserMapper.login(userName,password);
    }
}
