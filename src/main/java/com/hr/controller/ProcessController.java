package com.hr.controller;

import com.hr.entity.AoaBursement;
import com.hr.entity.AoaEvection;
import com.hr.entity.AoaOvertime;
import com.hr.entity.AoaProcessList;
import com.hr.service.IAoaProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * 流程管理模块
 */

@Controller
@RequestMapping("pc")
public class ProcessController {

    @Autowired
    private IAoaProcessService iAoaProcessService;

    //新建流程

    // 费用报销单
    @RequestMapping("addBursement")
    public String addBursement(AoaBursement aoaBursement){

        iAoaProcessService.addBursement(aoaBursement);

        return "";
    }

    //出差申请单
    @RequestMapping("addEvection")
    public String addEvection( AoaEvection aoaEvection, AoaProcessList aoaProcessList){

        //流程表添加
        iAoaProcessService.addAoaProcessList(aoaProcessList);

        iAoaProcessService.addEvection(aoaEvection);

        return "";
    }

    //加班申请单
    @RequestMapping("addOvertime")
    public String addOvertime(AoaOvertime aoaOvertime){

        iAoaProcessService.addOvertime(aoaOvertime);

        return "";
    }

    //转正申请单
    @RequestMapping("addRegular")
    public String addRegular(){

        return "";

    }

    //请假申请单
    @RequestMapping("addHoliday")
    public String addHoliday(){

        return "";
    }

    //离职申请单
    @RequestMapping("addResign")
    public String addResign(){

        return "";
    }

    /***
     * 我的申请
     * @param map
     * @return
     */

    //查询所有我的申请
    @RequestMapping("queryMyApplyFor")
    public String queryMyApplyFor(ModelMap map,AoaProcessList ProcessList,AoaProcessList aoaProcessList){

        System.out.println(ProcessList);

        List<AoaProcessList> aoaProcessLists = iAoaProcessService.queryMyApplyFor(aoaProcessList);

        map.addAttribute("aoaProcessLists",aoaProcessLists);

        return "Process/flowmanage";
    }

    //根据id查询
    @RequestMapping("queryProcessApplyForById")
    public String queryMyApplyForById(ModelMap map,int i){



        return "";
    }

    /***
     * 流程审核
     * @param map
     * @return
     */

    //查询所有的流程
    @RequestMapping("queryProcessApplyFor")
    public String queryProcessApplyFor(ModelMap map,AoaProcessList aoaProcessList){

        List<AoaProcessList> aoaProcessLists = iAoaProcessService.queryProcessApplyFor();

        map.addAttribute("aoaProcessLists",aoaProcessLists);

        System.out.println(aoaProcessLists);

        return "Process/auditing";
    }

}
