package com.hr.mapper;

import com.hr.entity.AoaBursement;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 费用报销
 */

public interface IAoaBursementMapper {

    //费用报销
    public void addBursement(AoaBursement aoaBursement);



}