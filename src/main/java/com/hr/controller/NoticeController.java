package com.hr.controller;

import com.hr.entity.AoaNoticeList;
import com.hr.entity.AoaUser;
import com.hr.mapper.IAoaNoticeUserRelationMapper;
import com.hr.service.IAoaNoticeListService;
import com.hr.service.IAoaNoticeUserRelationService;
import com.hr.service.IAoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公告管理模块
 */
@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private IAoaNoticeListService aoaNoticeListService;

    @Autowired
    private IAoaUserService aoaUserService;

    @Autowired
    private IAoaNoticeUserRelationService aoaNoticeUserRelationService;

    private Integer firstResult = 1;    //当前页码

    private Integer maxResult = 5;      //每页查询多少条

    private Boolean forUser = false;   //是否根据用户进行操作

    /**
     * 根据用户 查询通知列表
     *
     * @param session
     * @param map
     * @param title       通知标题
     * @param firstResult 当前页码
     * @return
     */
    @RequestMapping("queryNoticeByUser")
    public String queryNoticeByUser(HttpSession session, ModelMap map, String title, Integer firstResult, Boolean forUser) {

        String url = "notice/informlist";

        if (firstResult == null) {
            firstResult = this.firstResult;
        }

        if (forUser == null) {
            forUser = this.forUser;
        }

        Map<String, Object> paramMap = new HashMap<>();

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        //查询条件

        if (forUser) {  //根据当前登陆用户查询
            paramMap.put("userId", aoaUser.getUserId());

            //当用户点击查看通知时，修改用户所有通知信息的状态为已读
            aoaNoticeUserRelationService.updateNoticeForRead(aoaUser.getUserId());
        }

        paramMap.put("title", title);
        paramMap.put("firstResult", (firstResult - 1) * maxResult);
        paramMap.put("maxResult", maxResult);

        //通告列表
        List<AoaNoticeList> listAoaNoticeList = aoaNoticeListService.queryAoaNoticeList(paramMap);

        Long count = aoaNoticeListService.getNoticeCount(paramMap);

        Long total = count / maxResult;
        if (count % maxResult != 0) {
            total++;
        }

        map.addAttribute("listAoaNoticeList", listAoaNoticeList);
        map.addAttribute("firstResult", firstResult);
        map.addAttribute("maxResult", maxResult);
        map.addAttribute("count", count);
        map.addAttribute("total", total);
        map.addAttribute("title", title);

        return url;
    }

    /**
     * 更改公告的置顶状态
     *
     * @param noticeId 通知ID
     * @param isTop    置顶状态
     * @return
     */
    @RequestMapping("updateTop")
    public String updateNoticeTop(Long noticeId, Integer isTop) {

        Integer i = aoaNoticeListService.updateAoaNoticeForTop(noticeId, isTop);

        return "redirect:queryNoticeByUser?forUser=true";

    }

    /**
     * 查询指定通知
     *
     * @param noticeId 通知ID
     * @return
     */
    @RequestMapping("queryNoticeById")
    public String queryNoticeById(ModelMap map, Long noticeId) {

        String url = "/notice/informshow";

        AoaNoticeList aoaNoticeList = aoaNoticeListService.queryAoaNoticeListById(noticeId);

        map.addAttribute("aoaNoticeList", aoaNoticeList);

        return url;
    }


    /**
     * 将公告(通知)转发给其下属处理
     *
     * @param session
     * @param noticeId
     * @return
     */
    @RequestMapping("forwardUnder")
    public String forwardUnderstrapper(HttpSession session, Long noticeId) {

        String url = "redirect:queryNoticeByUser?forUser=true";

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        //查询其直属下属ID
        Long userId = aoaUserService.queryAoaUserForUnderstrapper(aoaUser.getPositionId(), aoaUser.getDeptId());

        //转发通知
        //修改中间表 为下属与通知 建立新关系
        aoaNoticeUserRelationService.addAoaNoticeUserRelation(noticeId, userId);

        //删除本用户与通知的关系
        aoaNoticeUserRelationService.deleteAoaNoticeUserRelationForNotice(noticeId, aoaUser.getUserId());

        return url;
    }

}
