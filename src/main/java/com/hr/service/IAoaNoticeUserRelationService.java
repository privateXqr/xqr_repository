package com.hr.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAoaNoticeUserRelationService {

    /**
     * 为指定用户与指定通知建立关系
     *
     * @param noticeId 通知ID
     * @param listUserId   用户ID
     * @return
     */
    public Integer addAoaNoticeUserRelation(@Param("noticeId") Long noticeId, @Param("listUserId") List<Long> listUserId);

    /**
     * 解除指定用户与通知之间的关系
     *
     * @param noticeId 通知ID
     * @param userId   用户ID
     * @return
     */
    public Integer deleteAoaNoticeUserRelationForNotice(@Param("noticeId") Long noticeId, @Param("userId") Long userId);

    /**
     * 统计用户有多少条未读通知
     *
     * @param userId 用户ID
     * @return
     */
    public Long queryUnreadNoticeForUser(@Param("userId") Long userId);

    /**
     * 修改用户的通知为已读
     *
     * @param userId 用户ID
     * @return
     */
    public Integer updateNoticeForRead(@Param("userId") Long userId);
}
