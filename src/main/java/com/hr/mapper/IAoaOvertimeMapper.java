package com.hr.mapper;

import com.hr.entity.AoaOvertime;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 加班表
 */
public interface IAoaOvertimeMapper {

    //加班申请
    public void addOvertime(AoaOvertime aoaOvertime);

}