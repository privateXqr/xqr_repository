package com.hr.mapper;

import com.hr.entity.AoaNoticeList;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 通知总表
 */
public interface IAoaNoticeListMapper {

    /**
     * 根据用户ID 查询其通知内容
     * @param userId    用户ID
     * @return
     */
    public List<AoaNoticeList> queryAoaNoticeList(@Param("userId") Long userId);

    public Integer updateAoaNoticeForTop();

}