package com.hr.service.impl;

import com.hr.entity.AoaInMailList;
import com.hr.mapper.IAoaInMailListMapper;
import com.hr.service.IAoaInMailListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaInMailListServiceImpl implements IAoaInMailListService {

    @Autowired
    private IAoaInMailListMapper aoaInMailListMapper;

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    public Integer addAoaMailList(AoaInMailList aoaInMailList) {
        return aoaInMailListMapper.addAoaMailList(aoaInMailList);
    }

    @Override
    @Cacheable("queryAoaInMailList")
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaInMailList> queryAoaInMailList(Map<String, Object> paramMap) {
        return aoaInMailListMapper.queryAoaInMailList(paramMap);
    }

    @Override
    @Cacheable("getCountForInMailBox")
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getCountForInMailBox(Map<String, Object> paramMap) {
        return aoaInMailListMapper.getCountForInMailBox(paramMap);
    }

    @Override
    @Cacheable("queryAoaInMailListWhere")
    @Transactional(propagation = Propagation.SUPPORTS)
    public AoaInMailList queryAoaInMailListWhere(Map<String, Object> paramMap) {
        return aoaInMailListMapper.queryAoaInMailListWhere(paramMap);
    }

    @Override
    @Cacheable("queryAoaOutMailList")
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaInMailList> queryAoaOutMailList(Map<String, Object> paramMap) {
        return aoaInMailListMapper.queryAoaOutMailList(paramMap);
    }

    @Override
    @Cacheable("getCountForOutMailBox")
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getCountForOutMailBox(Map<String, Object> paramMap) {
        return aoaInMailListMapper.getCountForOutMailBox(paramMap);
    }

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    public Integer deleteForOutMail(Map<String, Object> paramMap) {
        return aoaInMailListMapper.deleteForOutMail(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getStarStatus(Map<String, Object> paramMap) {
        return aoaInMailListMapper.getStarStatus(paramMap);
    }

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    public Integer updateAoaInMailListForStar(Map<String, Object> paramMap) {
        return aoaInMailListMapper.updateAoaInMailListForStar(paramMap);
    }
}
