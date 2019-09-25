package com.hr.mapper;

import com.hr.entity.AoaHoliday;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 请假表
 */
public interface IAoaHolidayMapper {

    //请假申请
    public void addHoliday(AoaHoliday aoaHoliday);

}