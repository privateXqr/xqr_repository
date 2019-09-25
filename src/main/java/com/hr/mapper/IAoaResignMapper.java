package com.hr.mapper;

import com.hr.entity.AoaRegular;
import com.hr.entity.AoaResign;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 离职表
 */
public interface IAoaResignMapper {

    //离职申请
    public void addResign(AoaRegular aoaRegular);

}