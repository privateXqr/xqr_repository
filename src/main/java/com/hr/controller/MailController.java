package com.hr.controller;

import com.hr.entity.AoaInMailList;
import com.hr.entity.AoaPublicChar;
import com.hr.entity.AoaUser;
import com.hr.service.IAoaInMailListService;
import com.hr.service.IAoaMailReciverService;
import com.hr.service.IAoaPublicCharService;
import com.hr.service.IAoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 邮件管理模块
 */
@Controller
@RequestMapping("mail")
public class MailController {

    @Autowired
    private IAoaPublicCharService aoaPublicCharService;

    @Autowired
    private IAoaUserService aoaUserService;

    @Autowired
    private IAoaInMailListService aoaInMailListService;

    @Autowired
    private IAoaMailReciverService aoaMailReciverService;

    private Boolean forUser = false;    //是否根据用户进行操作

    private Map<String,Object> paramMap = new HashMap<>();  //参数集合

    /**
     * 初始化邮件管理界面
     *
     * @param forUser 是否根据用户进行操作
     * @return
     */
    @RequestMapping("init")
    public String initMailMenu(Boolean forUser) {

        String url = "mail/mail";

        if (forUser == null) {
            forUser = this.forUser;
        }

        return url;
    }

    /**
     * 初始化写信页面
     *
     * @return
     */
    @RequestMapping("goWrite")
    public String goWriteMessage(ModelMap map, HttpSession session) {

        String url = "mail/mailwrite";

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        //查询字典表相关信息
        List<AoaPublicChar> listMailType = aoaPublicCharService.queryAoaPublicCharByType("发送邮件类型");
        List<AoaPublicChar> listMailLevel = aoaPublicCharService.queryAoaPublicCharByType("邮件状态");
        List<AoaPublicChar> listMailScope = aoaPublicCharService.queryAoaPublicCharByType("邮件范围");

        //查询用户通讯录(联系人)
        List<AoaUser> listAoaUser = aoaUserService.queryAoaUserForDirector(aoaUser.getUserId());

        map.addAttribute("listAoaUser", listAoaUser);

        map.addAttribute("listMailType", listMailType);
        map.addAttribute("listMailLevel", listMailLevel);
        map.addAttribute("listMailScope", listMailScope);

        return url;
    }

    /**
     * 发送邮件
     *
     * @return
     */
    @RequestMapping("send")
    public String sendMail(HttpSession session,AoaInMailList aoaInMailList) {

        String url = "redirect:/mail/init";

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        aoaInMailList.setMailInPushUserId(aoaUser.getUserId());

        if(aoaInMailList.getMailType() == 16){   //邮件

            if (aoaInMailList.getMailPush() == 0){   //内部邮件

                //重组收件人数组
                String[] receivers = aoaInMailList.getInReceiver().split(";");

                // 遍历收件人数组
                for (String receiver : receivers) {

                    aoaInMailList.setInReceiver(receiver);

                    //批量新增内部邮件
                    aoaInMailListService.addAoaMailList(aoaInMailList);

                    //获取收件人ID
                    Long userId = aoaUserService.queryAoaUserIdByUserName(receiver);

                    //为收件人 与 内部邮件 建立关系
                    aoaMailReciverService.addAoaMailReciver(aoaInMailList.getMailId(),userId);

                }
            }
        }
        return url;
    }
}
