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

    private Map<String, Object> paramMap = null;  //参数集合

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
    public String initMailMenu(HttpSession session, ModelMap map, Boolean forUser) {

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        String url = "mail/mail";

        if (forUser == null) {
            forUser = this.forUser;
        }

        //统计当前登陆用户有多少未读邮件
        Long mail_count = aoaMailReciverService.getUnreadInMailForUser(aoaUser.getUserId());

        map.addAttribute("mail_count", mail_count);

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

        //回信 | 转发 | 编辑
        if (aoaInMailList != null) {

            map.addAttribute("aoaInMailList", aoaInMailList);

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

        paramMap = new HashMap<>();

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

        paramMap = new HashMap<>();

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

        if (mailAccount == null || "".equals(mailAccount)) {   //内部邮件

            //新增内部邮件
            aoaInMailListService.addAoaMailList(aoaInMailList);

            if (aoaInMailList.getMailPush() == 1) {     //为发送时，才真正为收件人与邮件建立关系

                //重组收件人数组
                String[] receivers = aoaInMailList.getInReceiver().split(";");

                // 遍历收件人数组
                for (String receiver : receivers) {

                    //获取收件人ID
                    Long userId = aoaUserService.queryAoaUserIdByUserName(receiver);

                    //分别为每个收件人 与 内部邮件 建立关系
                    aoaMailReciverService.addAoaMailReciver(aoaInMailList.getMailId(), userId);
                }
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
        return url;
    }

    /**
     * 主要查询 查询邮箱
     *
     * @param map
     * @param session
     * @param firstResult 当前页码
     * @param forUser     根据用户查询
     * @param mailBoxType 邮箱类型
     * @param queryParam  高级查询参数
     * @return
     */
    @RequestMapping("queryMail")
    public String queryMailList(ModelMap map, HttpSession session, Integer firstResult, Boolean forUser, String mailBoxType, String queryParam) {

        paramMap = new HashMap<>();

        String url = "";

        if (firstResult == null) {
            firstResult = this.firstResult;
        }

        if (forUser == null) {
            forUser = this.forUser;
        }

        //根据用户查询
        if (forUser) {

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

        // 邮件箱
        List<AoaInMailList> listAoaInMailList = null;

        // 主要查询
        switch (mailBoxType) {
            //收件箱
            case "inMail":
                paramMap.put("isDel", 0);
                listAoaInMailList = aoaInMailListService.queryAoaInMailList(paramMap);
                count = aoaInMailListService.getCountForInMailBox(paramMap);
                url = "mail/mailinbox";
                break;
            //发件箱
            case "outMail":
                paramMap.put("mailPush", 1);
                listAoaInMailList = aoaInMailListService.queryAoaOutMailList(paramMap);
                count = aoaInMailListService.getCountForOutMailBox(paramMap);
                url = "mail/mailoutbox";
                break;
            //草稿箱
            case "draft":
                paramMap.put("mailPush", 0);
                listAoaInMailList = aoaInMailListService.queryAoaOutMailList(paramMap);
                count = aoaInMailListService.getCountForOutMailBox(paramMap);
                url = "mail/maildraftbox";
                break;
            case "rubbish":
                paramMap.put("isDel", 1);
                listAoaInMailList = aoaInMailListService.queryAoaInMailList(paramMap);
                count = aoaInMailListService.getCountForInMailBox(paramMap);
                url = "mail/mailrubbishbox";
                break;
        }

        total = count / maxResult;

        if (count % maxResult != 0) {
            total++;
        }

        map.addAttribute("listAoaInMailList", listAoaInMailList);

        map.addAttribute("firstResult", firstResult);
        map.addAttribute("maxResult", maxResult);
        map.addAttribute("count", count);
        map.addAttribute("total", total);

        map.addAttribute("mailBoxType", mailBoxType);

        return url;
    }

    /**
     * 查询指定邮件信息
     *
     * @param map
     * @param mailId 邮件ID
     * @return
     */
    @RequestMapping("queryMailById")
    public String queryMailListById(ModelMap map, HttpSession session, Long mailId, String mailBoxType) {

        String url = "/mail/mailsee";

        paramMap = new HashMap<>();

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        //设置邮件已读
        String[] mailIds = String.valueOf(mailId).split(",");

        paramMap.put("userId", aoaUser.getUserId());
        paramMap.put("mailIds", mailIds);

        aoaMailReciverService.batchUpdateAoaMailReciverForRead(paramMap);

        paramMap.put("mailId", mailId);

        AoaInMailList aoaInMailList = aoaInMailListService.queryAoaInMailListWhere(paramMap);

        map.addAttribute("aoaInMailList", aoaInMailList);
        map.addAttribute("mailBoxType", mailBoxType);

        return url;
    }

    /**
     * 邮箱操作汇总
     *
     * @param map
     * @param session
     * @param ids         邮件ID
     * @param mailBoxType 邮箱类型
     * @param oper        操作类型
     * @param firstResult 当前页码
     * @param forUser     是否根据用户进行随后查询
     * @return
     */
    @RequestMapping("mailOperation")
    public String mailOperation(ModelMap map, HttpSession session, String ids, String mailBoxType, String oper, Integer firstResult, Boolean forUser) {

        //转发主查询页面
        String url = "forward:/mail/queryMail";

        paramMap = new HashMap<>();

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        paramMap.put("userId", aoaUser.getUserId());
        paramMap.put("mailIds", ids.split(","));

        String[] mailIds = ids.split(",");

        if (forUser) {
            //根据用户进行查询
            map.addAttribute("forUser", true);
        }

        /*
        操作管理
        根据邮箱类型以及操作类型 分发操作
         */
        if (mailBoxType.equals("inMail") || mailBoxType.equals("rubbish")) {    //收件箱 | 垃圾箱
            switch (oper) {
                //删除
                case "del":
                    if (mailBoxType.equals("inMail")) {
                        aoaMailReciverService.batchDeleteAoaMailReciver(paramMap);
                    } else {
                        aoaMailReciverService.batchRealDeleteAoaMailReciver(paramMap);
                    }
                    break;
                //已读
                case "watch":
                    aoaMailReciverService.batchUpdateAoaMailReciverForRead(paramMap);
                    break;
                //星标
                case "star":
                    //遍历数组
                    for (String mailId : mailIds) {

                        paramMap.put("mailId", mailId);

                        //判断此邮件是否星标
                        Long isStar = aoaMailReciverService.getStarStatus(paramMap);

                        paramMap.put("isStar", isStar);

                        aoaMailReciverService.updateAoaMailReciverForStar(paramMap);
                    }
                    break;
            }
        } else if (mailBoxType.equals("outMail") || mailBoxType.equals("draft")) {  //发件箱 | 草稿箱
            switch (oper) {
                //删除
                case "del":
                    aoaInMailListService.deleteForOutMail(paramMap);
                    break;
                case "star":
                    //遍历数组
                    for (String mailId : mailIds) {
                        paramMap.put("mailId", mailId);

                        //判断此邮件是否星标
                        Long mailStar = aoaInMailListService.getStarStatus(paramMap);

                        paramMap.put("mailStar", mailStar);

                        //修改星标状态
                        aoaInMailListService.updateAoaInMailListForStar(paramMap);
                    }
                    break;
            }
        }
        map.addAttribute("mailBoxType", mailBoxType);   //邮箱类型
        map.addAttribute("firstResult", firstResult);   //当前页码
        return url;
    }

    /**
     * 获取未读邮件总数
     *
     * @param session
     * @return
     */
    @RequestMapping("getUnreadMailCount")
    @ResponseBody
    public Long getUnreadMailCount(HttpSession session) {

        AoaUser aoaUser = (AoaUser) session.getAttribute("aoaUser");

        return aoaMailReciverService.getUnreadInMailForUser(aoaUser.getUserId());

    }
}
