package com.hr.mapper;

import com.hr.entity.AoaRegular;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 转正表
 */

public interface IAoaRegularMapper {

    //转正申请
    public  void addRegular(AoaRegular aoaRegular);

}