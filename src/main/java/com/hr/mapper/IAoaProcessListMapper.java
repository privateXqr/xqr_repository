package com.hr.mapper;

import com.hr.entity.*;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  流程表
 */
public interface IAoaProcessListMapper {

    //添加流程
    public void addAoaProcessList(AoaProcessList aoaProcessList);

    //我的申请(list)
    public List<AoaProcessList> queryMyApplyFor(AoaProcessList aoaProcessList);

    //我的申请(ById)
    public AoaProcessList queryMyApplyForById(AoaPlanList aoaPlanList);

    //流程审核--根据时间查询
    public List<AoaProcessList> queryApplyFor();

    //流程审核 --ById
    public AoaProcessList queryApplyForById(AoaProcessList id);

    //审核流程 --修改
    public void updateApplyFor(AoaProcessList id);
}