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
public class AoaNoticeListServiceImpl implements IAoaNoticeListService{

    @Autowired
    private IAoaNoticeListMapper iAoaNoticeListMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaNoticeList> queryAoaNoticeListAll() {

        return iAoaNoticeListMapper.queryAoaNoticeListAll();

    }

    @Override
    public AoaNoticeList queryByAoaNoticeListId(int id) {

        return iAoaNoticeListMapper.queryByAoaNoticeListId(id);

    }

    @Override
    public void updateAoaNoticeList(AoaNoticeList aoaNoticeList) {

        iAoaNoticeListMapper.updateAoaNoticeList(aoaNoticeList);

    }

    @Override
    public void delAoaNoticeList(int id) {

        iAoaNoticeListMapper.delAoaNoticeList(id);

    }

    @Override
    public void addiAoaNoticeList(AoaNoticeList aoaNoticeList) {

        iAoaNoticeListMapper.addiAoaNoticeList(aoaNoticeList);

    }
}
