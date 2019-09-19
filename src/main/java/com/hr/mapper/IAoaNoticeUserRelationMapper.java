package com.hr.mapper;

import com.hr.entity.AoaNoticeUserRelation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 通知与用户 中间表
 */
@Repository
public interface IAoaNoticeUserRelationMapper {

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