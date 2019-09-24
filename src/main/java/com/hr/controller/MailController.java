package com.hr.controller;

import com.hr.entity.AoaInMailList;
import com.hr.entity.AoaMailnumber;
import com.hr.entity.AoaPublicChar;
import com.hr.entity.AoaUser;
import com.hr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private IAoaMailnumberService aoaMailnumberService;

    private Boolean forUser = false;    //是否根据用户进行操作    默认不根据

    private Map<String, Object> paramMap = new HashMap<>();  //参数集合

    private Integer firstResult = 1;        //当前页码

    private Integer maxResult = 5;          //每页条目数

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
     * @param map
     * @param aoaInMailList 承载参数实体
     * @return
     */
    @RequestMapping("goWrite")
    public String goWriteMessage(ModelMap map, AoaInMailList aoaInMailList) {

        String url = "mail/mailwrite";

        //回信或转发
        if (aoaInMailList != null) {
            if (aoaInMailList.getMailInPushName() != null) {    //回信
                map.addAttribute("mailInPushName", aoaInMailList.getMailInPushName());
            } else if (aoaInMailList.getMailTitle() != null) {  //转发
                map.addAttribute("mailTitle", aoaInMailList.getMailTitle());
                map.addAttribute("mailContent", aoaInMailList.getMailContent());
                map.addAttribute("mailFileId", aoaInMailList.getMailFileId());
            }
        }

        //查询字典表相关信息
        List<AoaPublicChar> listMailType = aoaPublicCharService.queryAoaPublicCharByType("发送邮件类型");
        List<AoaPublicChar> listMailLevel = aoaPublicCharService.queryAoaPublicCharByType("邮件状态");
        List<AoaPublicChar> listMailScope = aoaPublicCharService.queryAoaPublicCharByType("邮件范围");

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

            if (aoaInMailList.getMailNumberId() == null) {   //内部邮件

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
    public String queryAoaInMailList(HttpSession session, ModelMap map, Integer firstResult, Boolean forUser, String queryParam) {

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

        if (queryParam != null) { //高级查询

            if (queryParam.length() == 2) {
                switch (queryParam) {
                    case "邮件":
                        paramMap.put("mailType", 16);
                        break;
                    case "公告":
                        paramMap.put("mailType", 17);
                        break;
                    case "通知":
                        paramMap.put("mailType", 18);
                        break;
                    case "一般":
                        paramMap.put("mailStatusId", 20);
                        break;
                    case "重要":
                        paramMap.put("mailStatusId", 21);
                        break;
                    case "紧急":
                        paramMap.put("mailStatusId", 22);
                        break;
                    default:
                        paramMap.put("param", queryParam);
                }
            } else {
                paramMap.put("param", queryParam);
            }
            map.addAttribute("queryParam", queryParam);
        }
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

        map.addAttribute("firstResult", firstResult);
        map.addAttribute("maxResult", maxResult);
        map.addAttribute("count", count);
        map.addAttribute("total", total);

        return url;
    }

    /**
     * 查询指定邮件信息
     *
     * @param map
     * @param mailId 邮件ID
     * @return
     */
    @RequestMapping("queryInMailById")
    public String queryInMailListById(ModelMap map, HttpSession session, Long mailId) {

        String url = "/mail/mailsee";

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        //设置邮件已读
        String[] mailIds = String.valueOf(mailId).split(",");

        paramMap.put("userId", aoaUser.getUserId());
        paramMap.put("mailIds", mailIds);

        aoaMailReciverService.batchUpdateAoaMailReciverForRead(paramMap);

        paramMap.put("mailId", mailId);

        AoaInMailList aoaInMailList = aoaInMailListService.queryAoaInMailListWhere(paramMap);

        map.addAttribute("aoaInMailList", aoaInMailList);

        return url;
    }

    /**
     * 删除内部邮件
     *
     * @return
     */
    @RequestMapping("deleteInMail")
    public String batchDeleteInMail(HttpSession session, String ids) {

        String url = "redirect:/mail/queryInMail?forUser=true";

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        paramMap.put("userId", aoaUser.getUserId());
        paramMap.put("mailIds", ids.split(","));

        //批量删除用户与邮件的关系
        aoaMailReciverService.batchDeleteAoaMailReciver(paramMap);

        return url;
    }

    /**
     * 设置邮件已读
     *
     * @return
     */
    @RequestMapping("updateForRead")
    public String batchUpdateMailForRead(HttpSession session, String ids) {

        String url = "redirect:/mail/queryInMail?forUser=true";

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        paramMap.put("userId", aoaUser.getUserId());
        paramMap.put("mailIds", ids.split(","));


        return url;
    }

    /**
     * 内部邮件 操作汇总
     *
     * @param session
     * @param ids     邮件ID集
     * @param oper    操作类型
     * @return
     */
    @RequestMapping("inMailOperation")
    public String inMailOperation(HttpSession session, String ids, String oper) {

        String url = "redirect:/mail/queryInMail?forUser=true";

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        paramMap.put("userId", aoaUser.getUserId());
        paramMap.put("mailIds", ids.split(","));

        switch (oper) {
            case "del":
                aoaMailReciverService.batchUpdateAoaMailReciverForRead(paramMap);
                break;
            case "watch":
                aoaMailReciverService.batchUpdateAoaMailReciverForRead(paramMap);
                break;
            case "star":
                aoaMailReciverService.batchUpdateAoaMailReciverForStar(paramMap);
                break;
        }
        return url;
    }
}
