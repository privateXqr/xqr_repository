package com.hr.controller;

import com.hr.entity.AoaInMailList;
import com.hr.entity.AoaMailnumber;
import com.hr.entity.AoaPublicChar;
import com.hr.entity.AoaUser;
import com.hr.service.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

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

    @Autowired
    private IAoaMailnumberService aoaMailnumberService;

    private Boolean forUser = false;    //是否根据用户进行操作    默认不根据

    private Map<String, Object> paramMap = new HashMap<>();  //参数集合

    private Integer firstResult = 1;        //当前页码

    private Integer maxResult = 2;          //每页条目数

    private Long count;                     //总条目数

    private Long total;                     //总页码

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

//        //查询用户通讯录(联系人)
//        List<AoaUser> listAoaUser = aoaUserService.queryAoaUserForDirector(aoaUser.getUserId());

//        map.addAttribute("listAoaUser", listAoaUser);

        map.addAttribute("listMailType", listMailType);
        map.addAttribute("listMailLevel", listMailLevel);
        map.addAttribute("listMailScope", listMailScope);

        return url;
    }

    /**
     * 查询用户通讯录
     *
     * @return
     */
    @RequestMapping("queryAddressList")
    @ResponseBody
    public Map<String, Object> queryAddressList(HttpSession session, Integer firstResult) {

        Map<String, Object> map = new HashMap<>();

        if (firstResult == null) {
            firstResult = this.firstResult;
        }
        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        paramMap.put("userId", aoaUser.getUserId());

        paramMap.put("firstResult", (firstResult - 1) * maxResult);
        paramMap.put("maxResult", maxResult);

        //查询用户通讯录
        List<AoaUser> listAoaUser = aoaUserService.queryAoaUserForDirector(paramMap);

        //获取总条目数
        count = aoaUserService.getCountForDirector(paramMap);

        total = count / maxResult;

        if (count % maxResult != 0) {

            total++;
        }

        map.put("listAoaUser", listAoaUser);

        map.put("firstResult", firstResult);
        map.put("maxResult", maxResult);
        map.put("count", count);
        map.put("total", total);

        return map;
    }

    /**
     * 验证外部邮箱账号ID有效性
     *
     * @return
     */
    @RequestMapping("existsMailAccount")
    @ResponseBody
    public String existsMailAccount(String mailAccount) {

        String result = "error";

        AoaMailnumber aoaMailnumber = aoaMailnumberService.existsAoaMailnumber(mailAccount);

        result = aoaMailnumber == null ? "error" : "success";

        return result;
    }

    /**
     * 动态查询联系人邮箱账号
     *
     * @return
     */
    @RequestMapping("queryReceiverByMailAccount")
    @ResponseBody
    public List<AoaMailnumber> queryReceiverForAjax(HttpSession session, String mailAccount) {

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        paramMap.put("mailAccount", mailAccount);
        paramMap.put("userId", aoaUser.getUserId());

        return aoaMailnumberService.queryAoaMailNumberByMailAccount(paramMap);
    }

    /**
     * 发送邮件
     *
     * @return
     */
    @RequestMapping("send")
    public String sendMail(HttpSession session, HttpServletRequest request, MultipartFile file, AoaInMailList aoaInMailList, String mailAccount) {

        String url = "redirect:/mail/init";

//        File path = null;
//        try {
//            path = new File(ResourceUtils.getURL("classpath:").getPath());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (!file.isEmpty()) {
//            // 执行上传操作
//            String fileName = String.valueOf(Math.random()).substring(2);
//            File upload = new File(path.getAbsolutePath(),"static/images/fileimg/");
//            try {
//                file.transferTo(upload);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        //发件人ID
        aoaInMailList.setMailInPushUserId(aoaUser.getUserId());

        if (aoaInMailList.getMailType() == 16) {   //邮件

            if (aoaInMailList.getMailPush() == 0) {   //内部邮件

                //新增内部邮件
                aoaInMailListService.addAoaMailList(aoaInMailList);

                //重组收件人数组
                String[] receivers = aoaInMailList.getInReceiver().split(";");

                // 遍历收件人数组
                for (String receiver : receivers) {

                    //获取收件人ID
                    Long userId = aoaUserService.queryAoaUserIdByUserName(receiver);

                    //分别为每个收件人 与 内部邮件 建立关系
                    aoaMailReciverService.addAoaMailReciver(aoaInMailList.getMailId(), userId);
                }
            } else {  //外部邮件

                //根据外部邮箱账号获取邮箱账号ID
                AoaMailnumber aoaMailnumber = aoaMailnumberService.existsAoaMailnumber(mailAccount);

                //外部邮箱账号ID
                aoaInMailList.setMailNumberId(aoaMailnumber.getMailNumberId());
                aoaInMailList.setInReceiver(mailAccount);

                //新增外部邮件
                aoaInMailListService.addAoaMailList(aoaInMailList);
            }
        }
        return url;
    }

    /**
     * @param session
     * @param map         响应结果集
     * @param firstResult 当前页码
     * @param forUser     是否根据用户进行操作
     * @return
     */
    @RequestMapping("queryInMail")
    public String queryAoaInMailList(HttpSession session, ModelMap map, Integer firstResult, Boolean forUser, String param) {

        String url = "/mail/mailinbox";

        if (firstResult == null) {
            firstResult = this.firstResult;
        }

        if (forUser == null) {
            forUser = this.forUser;
        }

        if (forUser) {   //查询当前登陆用户收件箱(内部邮件)

            AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

            paramMap.put("userId", aoaUser.getUserId());
        }

        //判断是否为数字类型


        paramMap.put("firstResult", (firstResult - 1) * maxResult);
        paramMap.put("maxResult", maxResult);

        //查询收件箱
        List<AoaInMailList> listAoaInMailList = aoaInMailListService.queryAoaInMailList(paramMap);

        //获取收件箱总条目数
        count = aoaInMailListService.getCountForInMailBox(paramMap);

        total = count / maxResult;

        if (count % maxResult != 0) {
            total++;
        }

        map.addAttribute("listAoaInMailList", listAoaInMailList);
        map.addAttribute("param", param);

        map.addAttribute("firstResult", firstResult);
        map.addAttribute("maxResult", maxResult);
        map.addAttribute("count", count);
        map.addAttribute("total", total);

        return url;
    }
}
