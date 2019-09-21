package com.hr.mapper;

import com.hr.entity.*;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  流程表
 */
public interface IAoaProcessListMapper {

    //添加流程
    public void addProcess(AoaProcessList aoaProcessList);

    //我的申请(list)
    public List<AoaProcessList> queryMyApplyFor(AoaProcessList aoaProcessList);

    //我的申请(ById)
    public AoaProcessList queryMyApplyForById(AoaPlanList aoaPlanList);
}