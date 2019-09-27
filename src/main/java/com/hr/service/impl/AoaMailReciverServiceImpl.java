package com.hr.service.impl;

import com.hr.entity.AoaInMailList;
import com.hr.mapper.IAoaMailReciverMapper;
import com.hr.service.IAoaMailReciverService;
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
public class AoaMailReciverServiceImpl implements IAoaMailReciverService {

    @Autowired
    private IAoaMailReciverMapper aoaMailReciverMapper;

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    public Integer addAoaMailReciver(Long mailId, Long userId) {
        return aoaMailReciverMapper.addAoaMailReciver(mailId, userId);
    }

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    public Integer batchDeleteAoaMailReciver(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.batchDeleteAoaMailReciver(paramMap);
    }

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    public Integer batchUpdateAoaMailReciverForRead(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.batchUpdateAoaMailReciverForRead(paramMap);
    }

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getStarStatus(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.getStarStatus(paramMap);
    }

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    public Integer updateAoaMailReciverForStar(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.updateAoaMailReciverForStar(paramMap);
    }

    @Override
    @CacheEvict(value = {"queryAoaInMailList", "getCountForInMailBox",
            "queryAoaOutMailList", "getCountForOutMailBox", "queryAoaInMailListWhere",
            "getUnreadInMailForUser"}, allEntries = true)
    public Integer batchRealDeleteAoaMailReciver(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.batchRealDeleteAoaMailReciver(paramMap);
    }

    @Override
    @Cacheable("getUnreadInMailForUser")
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getUnreadInMailForUser(Long userId) {
        return aoaMailReciverMapper.getUnreadInMailForUser(userId);
    }
}
