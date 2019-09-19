package com.hr.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAoaNoticeUserRelationService {

    /**
     * 为指定用户与指定通知建立关系
     *
     * @param noticeId 通知ID
     * @param userId   用户ID
     * @return
     */
    public Integer addAoaNoticeUserRelation(@Param("noticeId") Long noticeId, @Param("userId") Long userId);

    /**
     * 解除指定用户与通知之间的关系
     *
     * @param noticeId 通知ID
     * @param userId   用户ID
     * @return
     */
    public Integer deleteAoaNoticeUserRelationForNotice(@Param("noticeId") Long noticeId, @Param("userId") Long userId);
}
