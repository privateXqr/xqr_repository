package com.hr.service.impl;

import com.hr.entity.AoaUser;
import com.hr.mapper.IAoaUserMapper;
import com.hr.service.IAoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaUserServiceImpl implements IAoaUserService {

    @Autowired
    private IAoaUserMapper aoaUserMapper;

    @Override
    //@Cacheable("login")
    @Transactional(propagation = Propagation.SUPPORTS)
    public AoaUser login(String userName, String password) {
        return aoaUserMapper.login(userName, password);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long queryAoaUserForUnderstrapper(Long positionId, Long deptId) {
        return aoaUserMapper.queryAoaUserForUnderstrapper(positionId, deptId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaUser> queryAoaUserForDirector(Long userId) {
        return aoaUserMapper.queryAoaUserForDirector(userId);
    }

    @Override
    public Long queryAoaUserIdByUserName(String userName) {
        return aoaUserMapper.queryAoaUserIdByUserName(userName);
    }
}
