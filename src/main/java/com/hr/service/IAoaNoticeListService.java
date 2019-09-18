package com.hr.service;

import com.hr.entity.AoaNoticeList;

import java.util.List;

public interface IAoaNoticeListService {

    /**
     * 根据用户ID 查询其通知内容
     *
     * @param userId 用户ID
     * @return
     */
    public List<AoaNoticeList> queryAoaNoticeList(Long userId);
}
