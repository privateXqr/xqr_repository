package com.hr.service.impl;

import com.hr.entity.AoaInMailList;
import com.hr.mapper.IAoaInMailListMapper;
import com.hr.service.IAoaInMailListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaInMailList> queryAoaInMailList(Map<String, Object> paramMap) {
        return aoaInMailListMapper.queryAoaInMailList(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getCountForInMailBox(Map<String, Object> paramMap) {
        return aoaInMailListMapper.getCountForInMailBox(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public AoaInMailList queryAoaInMailListWhere(Map<String, Object> paramMap) {
        return aoaInMailListMapper.queryAoaInMailListWhere(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaInMailList> queryAoaOutMailList(Map<String, Object> paramMap) {
        return aoaInMailListMapper.queryAoaOutMailList(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getCountForOutMailBox(Map<String, Object> paramMap) {
        return aoaInMailListMapper.getCountForOutMailBox(paramMap);
    }

    @Override
    public Integer deleteForOutMail(Map<String, Object> paramMap) {
        return aoaInMailListMapper.deleteForOutMail(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getStarStatus(Map<String, Object> paramMap) {
        return aoaInMailListMapper.getStarStatus(paramMap);
    }

    @Override
    public Integer updateAoaInMailListForStar(Map<String, Object> paramMap) {
        return aoaInMailListMapper.updateAoaInMailListForStar(paramMap);
    }
}
