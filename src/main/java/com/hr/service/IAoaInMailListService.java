package com.hr.service;

import com.hr.entity.AoaInMailList;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface IAoaInMailListService {

    /**
     * 新建内部邮件
     *
     * @param aoaInMailList 邮件
     * @return
     */
    public Integer addAoaMailList(AoaInMailList aoaInMailList);
}