package com.hr.mapper;

import com.hr.entity.AoaEvection;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 出差表
 */
public interface IAoaEvectionMapper {

    //出差申请
    public void addEvection(AoaEvection aoaEvection);

}