package com.hr.service.impl;

import com.hr.entity.AoaPublicChar;
import com.hr.mapper.IAoaPublicCharMapper;
import com.hr.service.IAoaPublicCharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaPublicCharServiceImpl implements IAoaPublicCharService{

    @Autowired
    private IAoaPublicCharMapper aoaPublicCharMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaPublicChar> queryAoaPublicCharByType(String charType) {
        return aoaPublicCharMapper.queryAoaPublicCharByType(charType);
    }
}
