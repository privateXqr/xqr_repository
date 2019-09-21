package com.hr.controller;

import com.hr.entity.AoaInMailList;
import com.hr.entity.AoaPublicChar;
import com.hr.entity.AoaUser;
import com.hr.service.IAoaInMailListService;
import com.hr.service.IAoaPublicCharService;
import com.hr.service.IAoaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    private Boolean forUser = false;    //是否根据用户进行操作

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
    public String sendMail(AoaInMailList aoaInMailList,Integer inmail) {

        String url = "redirect:/mail/init";

        if(aoaInMailList.getMailType() == 16){   //邮件

            if (inmail == 1){   //内部邮件

                //重组收件人数组
                String[] receivers = aoaInMailList.getInReceiver().split(";");

                //新增内部邮件
                aoaInMailListService.addAoaMailList(aoaInMailList,receivers);

                //为新邮件和目标用户建立关系

            }
        }


        return url;
    }
}
