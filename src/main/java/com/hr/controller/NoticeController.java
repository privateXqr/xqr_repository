package com.hr.controller;

import com.hr.entity.AoaNoticeList;
import com.hr.entity.AoaUser;
import com.hr.mapper.IAoaNoticeListMapper;
import com.hr.service.IAoaNoticeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 公告管理模块
 */
@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private IAoaNoticeListService aoaNoticeListService;

    /**
     * 根据用户 查询通知列表
     *
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("queryNoticeByUser")
    public String queryNoticeByUser(HttpSession session, ModelMap map) {

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        List<AoaNoticeList> listAoaNoticeList = aoaNoticeListService.queryAoaNoticeList(aoaUser.getUserId());

        map.addAttribute("listAoaNoticeList", listAoaNoticeList);

        return "notice/informlist";
    }

    @RequestMapping("updateTop")
    @ResponseBody
    public Integer updateNoticeTop(Long noticeId,Integer isTop){

        System.out.println(isTop);

        return null;

    }
}
