package com.hr.service;

import com.hr.entity.AoaPublicChar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAoaPublicCharService {

    /**
     * 查询指定类型的公共字段
     *
     * @param charType 字段类型
     * @return
     */
    public List<AoaPublicChar> queryAoaPublicCharByType(@Param("charType") String charType);
}
