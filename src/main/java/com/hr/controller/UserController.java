package com.hr.controller;

import com.hr.entity.AoaUser;
import com.hr.mapper.IAoaNoticeUserRelationMapper;
import com.hr.service.IAoaMailReciverService;
import com.hr.service.IAoaNoticeUserRelationService;
import com.hr.service.IAoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     *
     * @param session
     * @param map
     * @param userName 用户名/手机号
     * @param password 密码
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public String login(HttpSession session, ModelMap map, String userName, String password, String code) {

        String result = "";

        AoaUser aoaUser = aoaUserService.login(userName, password);

        if (aoaUser != null) {   //用户名密码正确

            String sysCode = (String) session.getAttribute("code");

            if (code.equalsIgnoreCase(sysCode)) {   //验证码正确

                //成功登陆
                session.setAttribute("aoaUser", aoaUser);

                result = "success";

            } else {  //验证码错误

                result = "errorCode";
            }

        } else {

            result = "errorUser";

        }
        return result;
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
