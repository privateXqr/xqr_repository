package com.hr.controller;

import com.hr.entity.AoaTaskList;
import com.hr.entity.AoaUser;
import com.hr.service.IAoaTaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 任务模块
 */
@Controller
@RequestMapping("task")
public class TaskController {

    @Autowired
    private IAoaTaskListService aoaTaskListService;

    private Integer firstResult = 1;        //当前页码

    private final Integer maxResult = 1;    //每页条目数

    private Long total;                     //总页码

    private Long count;                     //总条目数

    private Boolean forUser = false;        //是否根据用户操作

    private Map<String, Object> paramMap;    //参数集合

    /**
     * 主要查询 查询任务列表
     *
     * @param map
     * @param session
     * @param aoaTaskList 参数承载实体
     * @param firstResult 当前页码
     * @param forUser     是否根据用户操作
     * @return
     */
    @RequestMapping("queryTaskList")
    public String queryTaskList(ModelMap map, HttpSession session, AoaTaskList aoaTaskList, Integer firstResult, Boolean forUser) {

        String url = "task/mytask";

        paramMap = new HashMap<>();     //参数承载集合

        if (firstResult == null) {
            firstResult = this.firstResult;
        }

        if (forUser == null) {
            forUser = this.forUser;
        }

        //根据用户操作
        if (forUser) {

            AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

            paramMap.put("userId", aoaUser.getUserId());

        }

        //分页
        paramMap.put("firstResult", (firstResult - 1) * maxResult);
        paramMap.put("maxResult", maxResult);

        //查询任务列表
        List<AoaTaskList> listAoaTaskList = aoaTaskListService.queryAoaTaskList(paramMap);

        //获取总元素数
        count = aoaTaskListService.getCountForTaskList(paramMap);

        total = count / maxResult;

        if (count % maxResult != 0) {
            total++;
        }

        map.addAttribute("listAoaTaskList", listAoaTaskList);

        map.addAttribute("firstResult", firstResult);
        map.addAttribute("maxResult", maxResult);
        map.addAttribute("count", count);
        map.addAttribute("total", total);

        return url;
    }
}
