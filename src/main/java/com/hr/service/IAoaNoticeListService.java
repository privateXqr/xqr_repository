package com.hr.service;

import com.hr.entity.AoaNoticeList;

import java.util.List;
import java.util.Map;

public interface IAoaNoticeListService {

    /**
     * 根据用户ID 查询其通知内容
     *
     * @param paramMap 参数列表
     * @return
     */
    public List<AoaNoticeList> queryAoaNoticeList(Map<String,Object> paramMap);

    /**
     * 修改通知置顶状态
     * @return
     */
    public Integer updateAoaNoticeForTop(Long noticeId,Integer isTop);

    /**
     * 获取总条目数
     * @param paramMap
     * @return
     */
    public Long getNoticeCount(Map<String,Object> paramMap);

    /**
     * 根据ID 查询指定通知
     *
     * @param noticeId 通知ID
     * @return
     */
    public AoaNoticeList queryAoaNoticeListById(Long noticeId);
}
