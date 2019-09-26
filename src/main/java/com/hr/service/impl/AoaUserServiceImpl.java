package com.hr.service.impl;

import com.hr.entity.AoaUser;
import com.hr.mapper.IAoaUserMapper;
import com.hr.service.IAoaUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaUserServiceImpl implements IAoaUserService {

    @Autowired
    private IAoaUserMapper aoaUserMapper;

    @Override
    @Cacheable("login")
    @Transactional(propagation = Propagation.SUPPORTS)
    public AoaUser login(String userName, String password) {
        return aoaUserMapper.login(userName, password);
    }

    @Override
    public List<Long> queryAoaUserForUnderstrapper(@Param("userId") Long userId) {
        return aoaUserMapper.queryAoaUserForUnderstrapper(userId);
    }

    @Override
    @Cacheable("queryAoaUserForDirector")
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaUser> queryAoaUserForDirector(Map<String, Object> paramMap) {
        return aoaUserMapper.queryAoaUserForDirector(paramMap);
    }

    @Override
    @Cacheable("queryAoaUserIdByUserName")
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long queryAoaUserIdByUserName(String userName) {
        return aoaUserMapper.queryAoaUserIdByUserName(userName);
    }

    @Override
    @Cacheable("getCountForDirector")
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getCountForDirector(Map<String, Object> paramMap) {
        return aoaUserMapper.getCountForDirector(paramMap);
    }
}
