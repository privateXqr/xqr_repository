package com.hr.service.impl;

import com.hr.entity.AoaInMailList;
import com.hr.mapper.IAoaInMailListMapper;
import com.hr.service.IAoaInMailListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaInMailListServiceImpl implements IAoaInMailListService{

    @Autowired
    private IAoaInMailListMapper aoaInMailListMapper;

    @Override
    public Integer addAoaMailList(AoaInMailList aoaInMailList) {
        return aoaInMailListMapper.addAoaMailList(aoaInMailList);
    }
}
