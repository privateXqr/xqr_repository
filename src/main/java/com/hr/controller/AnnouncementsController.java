package com.hr.controller;

import com.hr.entity.AoaNoticeList;
import com.hr.service.IAoaNoticeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *通知管理模块
 *
 */
@Controller
@RequestMapping("acc")
public class AnnouncementsController {

    @Autowired
    private IAoaNoticeListService iAoaNoticeListService;

    //查询所有的通知
    @RequestMapping("queryAnnouncementsAll")
    public String queryAnnouncementsAll(ModelMap map){

        List<AoaNoticeList> aoaNoticeLists = iAoaNoticeListService.queryAoaNoticeListAll();

        map.addAttribute("list",aoaNoticeLists);

        return "informmanage";
    }

    @RequestMapping("goUpdateAnnouncements")
    public String goUpdateAnnouncements(HttpServletRequest request){

        String id = request.getParameter("");

        iAoaNoticeListService.queryByAoaNoticeListId(Integer.parseInt(id));

        return "";
    }

}
