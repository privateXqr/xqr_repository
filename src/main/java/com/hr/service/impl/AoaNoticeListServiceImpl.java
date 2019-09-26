package com.hr.service.impl;

import com.hr.entity.AoaNoticeList;
import com.hr.mapper.IAoaNoticeListMapper;
import com.hr.service.IAoaNoticeListService;
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
public class AoaNoticeListServiceImpl implements IAoaNoticeListService {

    @Autowired
    private IAoaNoticeListMapper aoaNoticeListMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaNoticeList> queryAoaNoticeListAll() {

        return aoaNoticeListMapper.queryAoaNoticeListAll();

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public AoaNoticeList queryByAoaNoticeListId(int id) {

        return aoaNoticeListMapper.queryByAoaNoticeListId(id);

    }

    @Override
    public void updateAoaNoticeList(AoaNoticeList aoaNoticeList) {

        aoaNoticeListMapper.updateAoaNoticeList(aoaNoticeList);

    }

    @Override
    public void delAoaNoticeList(int id) {

        aoaNoticeListMapper.delAoaNoticeList(id);

    }

    @Override
    public void addiAoaNoticeList(AoaNoticeList aoaNoticeList) {

        aoaNoticeListMapper.addiAoaNoticeList(aoaNoticeList);

    }

    @Override
    @Cacheable("queryAoaNoticeList")
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaNoticeList> queryAoaNoticeList(Map<String, Object> paramMap) {
        return aoaNoticeListMapper.queryAoaNoticeList(paramMap);
    }

    @Override
    @CacheEvict(value = {"queryAoaNoticeListById", "getNoticeCount", "queryAoaNoticeList"}, allEntries = true)
    public Integer updateAoaNoticeForTop(Long noticeId, Integer isTop) {
        return aoaNoticeListMapper.updateAoaNoticeForTop(noticeId, isTop);
    }

    @Override
    @Cacheable("getNoticeCount")
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getNoticeCount(Map<String, Object> paramMap) {
        return aoaNoticeListMapper.getNoticeCount(paramMap);
    }

    @Override
    @Cacheable("queryAoaNoticeListById")
    @Transactional(propagation = Propagation.SUPPORTS)
    public AoaNoticeList queryAoaNoticeListById(Long noticeId) {
        return aoaNoticeListMapper.queryAoaNoticeListById(noticeId);
    }


}
