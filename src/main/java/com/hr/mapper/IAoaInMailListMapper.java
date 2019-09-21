package com.hr.mapper;

import com.hr.entity.AoaInMailList;
import org.apache.ibatis.annotations.Param;

/**
 * 内部邮件表
 */
public interface IAoaInMailListMapper {

    /**
     * 新建内部邮件
     *
     * @param aoaInMailList 内部邮件实体
     * @param receivers     收件人
     * @return
     */
    public Integer addAoaMailList(@Param("aoaInMailList") AoaInMailList aoaInMailList, @Param("receivers") String[] receivers);
}