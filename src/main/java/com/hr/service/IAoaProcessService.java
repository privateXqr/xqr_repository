package com.hr.service;

import com.hr.entity.*;

import java.util.List;

/**
 * 流程管理服务
 */
public interface IAoaProcessService {

    /***
     *  新建流程
     *  @return
     */

    //费用报销申请
    public void addBursement(AoaBursement aoaBursement);

    //出差申请
    public void addEvection(AoaEvection aoaEvection);

    //加班申请
    public void addOvertime(AoaOvertime aoaOvertime);

    //转正申请
    public  void addRegular(AoaRegular aoaRegular);

    //请假申请
    public void addHoliday(AoaHoliday aoaHoliday);

    //离职申请
    public void addResign(AoaRegular aoaRegular);

    //普通流程添加
    public void addAoaProcessList(AoaProcessList aoaProcessList);

    /***
     *  我的流程
     * @return
     */

    //我的申请(list)
    public List<AoaProcessList> queryMyApplyFor(AoaProcessList aoaProcessList);

    //我的申请(ById)
    public AoaProcessList queryMyApplyForById(AoaProcessList aoaProcessList);


    /**
     * 流程审核
     * @return
     */

    //流程审核--根据时间查询
    public List<AoaProcessList> queryProcessApplyFor();

    //流程审核 --ById
    public AoaProcessList queryApplyForById(AoaProcessList id);

    //审核流程 --修改
    public void updateApplyFor(AoaProcessList id);

}
