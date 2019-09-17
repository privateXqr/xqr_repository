package com.hr.controller;

import com.hr.entity.AoaUser;
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

    /**
     * 登陆
     * @param session
     * @param map
     * @param userName  用户名/手机号
     * @param password  密码
     * @return
     */
    @RequestMapping("login")
    public String login(HttpSession session, ModelMap map, String userName, String password) {

        String url = "redirect:/login.html";

        AoaUser aoaUser = aoaUserService.login(userName, password);

        if (aoaUser != null){   //成功登陆
            session.setAttribute("aoaUser",aoaUser);

            url = "forward:/sys/initMenu";  //转发至初始化菜单
        }

        return url;
    }
}
