package com.hr.controller;

import com.hr.entity.AoaSysMenu;
import com.hr.entity.AoaUser;
import com.hr.service.IAoaMailReciverService;
import com.hr.service.IAoaNoticeUserRelationService;
import com.hr.service.IAoaSysMenuService;
import com.hr.util.MenuHelper;
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

    @Autowired
    private IAoaNoticeUserRelationService aoaNoticeUserRelationService;

    @Autowired
    private IAoaMailReciverService aoaMailReciverService;

    @Autowired
    private MenuHelper menuHelper;

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

        //设置高级查询参数
        paramMap.put("roleId", aoaUser.getRoleId());
        paramMap.put("menuName",menuName);      //父级菜单名|子级菜单名

        List<AoaSysMenu> listAoaSysUser = aoaSysMenuService.queryAoaSysMenu(paramMap);  //查询系统用户权限

        if (menuName != null && !menuName.equals("")){
            listAoaSysUser = menuHelper.initMenuWhere(listAoaSysUser,paramMap);
        }

        //统计当前登陆用户有多少条未读通知
        Long notice_count = aoaNoticeUserRelationService.queryUnreadNoticeForUser(aoaUser.getUserId());

        //统计当前登陆用户有多少未读邮件
        Long mail_count = aoaMailReciverService.getUnreadInMailForUser(aoaUser.getUserId());

        map.addAttribute("notice_count", notice_count);
        map.addAttribute("mail_count", mail_count);
        map.addAttribute("listAoaSysUser", listAoaSysUser);

        return url;
    }
}
