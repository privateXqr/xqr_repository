package com.hr.service.impl;

import com.hr.entity.AoaNoticeList;
import com.hr.mapper.IAoaNoticeListMapper;
import com.hr.service.IAoaNoticeListService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<AoaNoticeList> queryAoaNoticeList(Map<String, Object> paramMap) {
        return aoaNoticeListMapper.queryAoaNoticeList(paramMap);
    }

    @Override
    public Integer updateAoaNoticeForTop(Long noticeId, Integer isTop) {
        return aoaNoticeListMapper.updateAoaNoticeForTop(noticeId,isTop);
    }

    @Override
    public Long getNoticeCount(Map<String, Object> paramMap) {
        return aoaNoticeListMapper.getNoticeCount(paramMap);
    }

    @Override
    public AoaNoticeList queryAoaNoticeListById(Long noticeId) {
        return aoaNoticeListMapper.queryAoaNoticeListById(noticeId);
    }
}
