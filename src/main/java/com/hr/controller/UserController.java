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

    @RequestMapping("login")
    public String login(HttpSession session, ModelMap map, String userName, String password) {

        String url = "redirect:/login.html";

        AoaUser aoaUser = aoaUserService.login(userName, password);

        if (aoaUser != null){
            session.setAttribute("aoaUser",aoaUser);

            url = "index";
        }

        return url;
    }
}
