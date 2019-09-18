package com.hr.service.impl;

import com.hr.entity.AoaNoticeList;
import com.hr.mapper.IAoaNoticeListMapper;
import com.hr.service.IAoaNoticeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaNoticeListServiceImpl implements IAoaNoticeListService {

    @Autowired
    private IAoaNoticeListMapper aoaNoticeListMapper;

    @Override
    public List<AoaNoticeList> queryAoaNoticeList(Long userId) {
        return aoaNoticeListMapper.queryAoaNoticeList(userId);
    }
}
