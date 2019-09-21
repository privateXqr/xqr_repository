package com.hr.service;

import com.hr.entity.*;

import java.util.List;

/**
 * 流程管理
 */
public interface IAoaProcessService {

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

    //我的申请(list)
    public List<AoaProcessList> queryMyApplyFor(AoaProcessList AoaProcessList);

    //普通流程添加
    public void addAoaProcessList(AoaProcessList aoaProcessList);
}
