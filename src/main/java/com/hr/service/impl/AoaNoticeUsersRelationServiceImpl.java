package com.hr.service.impl;

import com.hr.mapper.IAoaNoticeUserRelationMapper;
import com.hr.service.IAoaNoticeUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaNoticeUsersRelationServiceImpl implements IAoaNoticeUserRelationService {

    @Autowired
    private IAoaNoticeUserRelationMapper aoaNoticeUserRelationMapper;

    @Override
    public Integer addAoaNoticeUserRelation(Long noticeId, Long userId) {
        return aoaNoticeUserRelationMapper.addAoaNoticeUserRelation(noticeId,userId);
    }

    @Override
    public Integer deleteAoaNoticeUserRelationForNotice(Long noticeId, Long userId) {
        return aoaNoticeUserRelationMapper.deleteAoaNoticeUserRelationForNotice(noticeId,userId);
    }
}
