package com.hr.mapper;

import com.hr.entity.AoaPublicChar;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 公共字段字典表
 */
public interface IAoaPublicCharMapper {

    /**
     * 查询指定类型的公共字段
     *
     * @param charType 字段类型
     * @return
     */
    public List<AoaPublicChar> queryAoaPublicCharByType(@Param("charType") String charType);

}