package com.hr.controller;

import com.hr.entity.AoaUser;
import com.hr.mapper.IAoaNoticeUserRelationMapper;
import com.hr.service.IAoaNoticeUserRelationService;
import com.hr.service.IAoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 用户管理模块
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IAoaUserService aoaUserService;

    @Autowired
    private IAoaNoticeUserRelationService aoaNoticeUserRelationService;

    /**
     * 登陆
     *
     * @param session
     * @param map
     * @param userName 用户名/手机号
     * @param password 密码
     * @return
     */
    @RequestMapping("login")
    public String login(HttpSession session, ModelMap map, String userName, String password) {

        String url = "redirect:/login.html";

        AoaUser aoaUser = aoaUserService.login(userName, password);

        if (aoaUser != null) {   //成功登陆
            session.setAttribute("aoaUser", aoaUser);

            //统计当前登陆用户有多少条未读通知
            Long notice_count = aoaNoticeUserRelationService.queryUnreadNoticeForUser(aoaUser.getUserId());

            map.addAttribute("notice_count", notice_count);

            url = "forward:/sys/initMenu";  //转发至初始化菜单
        }

        return url;
    }

    /**
     * 登出
     *
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session) {

        String url = "redirect:/login.html";

        session.removeAttribute("aoaUser");

        return url;
    }
}
