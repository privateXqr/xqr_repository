package com.hr.service.impl;

import com.hr.mapper.IAoaNoticeUserRelationMapper;
import com.hr.service.IAoaNoticeUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaNoticeUsersRelationServiceImpl implements IAoaNoticeUserRelationService {

    @Autowired
    private IAoaNoticeUserRelationMapper aoaNoticeUserRelationMapper;

    @Override
    public Integer addAoaNoticeUserRelation(Long noticeId, List<Long> listUserId) {
        return aoaNoticeUserRelationMapper.addAoaNoticeUserRelation(noticeId, listUserId);
    }

    @Override
    @CacheEvict(value = {"queryAoaNoticeListById", "getNoticeCount", "queryAoaNoticeList"}, allEntries = true)
    public Integer deleteAoaNoticeUserRelationForNotice(Long noticeId, Long userId) {
        return aoaNoticeUserRelationMapper.deleteAoaNoticeUserRelationForNotice(noticeId, userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long queryUnreadNoticeForUser(Long userId) {
        return aoaNoticeUserRelationMapper.queryUnreadNoticeForUser(userId);
    }


    @Override
    @CacheEvict(value = {"queryAoaNoticeListById", "getNoticeCount", "queryAoaNoticeList"}, allEntries = true)
    public Integer updateNoticeForRead(Long userId, Long noticeId) {
        return aoaNoticeUserRelationMapper.updateNoticeForRead(userId,noticeId);
    }
}
