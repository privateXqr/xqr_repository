package com.hr.controller;

import com.hr.entity.AoaSysMenu;
import com.hr.entity.AoaUser;
import com.hr.service.IAoaSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统管理模块
 */
@Controller
@RequestMapping("sys")
public class SystemController {

    @Autowired
    private IAoaSysMenuService aoaSysMenuService;

    /**
     * 初始化首页菜单
     *
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("initMenu")
    public String initMenu(HttpSession session, ModelMap map, String menuName) {

        String url = "index";

        Map<String, Object> paramMap = new HashMap<>();

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");     //取得用户对象

        paramMap.put("roleId", aoaUser.getRoleId());

        paramMap.put("menuName",menuName);

        List<AoaSysMenu> listAoaSysUser = aoaSysMenuService.queryAoaSysMenu(paramMap);  //查询系统用户权限

        map.addAttribute("listAoaSysUser", listAoaSysUser);

        return url;
    }
}
