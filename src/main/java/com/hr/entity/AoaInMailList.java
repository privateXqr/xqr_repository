package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class AoaInMailList implements Serializable {
    private Long mailId;

    private String mailContent;

    private Timestamp mailCreateTime;

    private Long mailFileId;

    private String mailTitle;

    private Long mailType;

    private Long mailInPushUserId;

    private String inReceiver;

    private Long mailStatusId;

    private Long mailNumberId;

    private Integer mailDel;

    private Integer mailPush;

    private Integer mailStar;

    private String mailInPushName;

    private List<AoaMailReciver> listAoaMailReciver;

    private AoaAttachmentList aoaAttachmentList;

    public List<AoaMailReciver> getListAoaMailReciver() {
        return listAoaMailReciver;
    }

    public void setListAoaMailReciver(List<AoaMailReciver> listAoaMailReciver) {
        this.listAoaMailReciver = listAoaMailReciver;
    }

    public AoaAttachmentList getAoaAttachmentList() {
        return aoaAttachmentList;
    }

    public void setAoaAttachmentList(AoaAttachmentList aoaAttachmentList) {
        this.aoaAttachmentList = aoaAttachmentList;
    }

    public String getMailInPushName() {
        return mailInPushName;
    }

    public void setMailInPushName(String mailInPushName) {
        this.mailInPushName = mailInPushName;
    }

    public Long getMailId() {
        return mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent == null ? null : mailContent.trim();
    }

    public Timestamp getMailCreateTime() {
        return mailCreateTime;
    }

    public void setMailCreateTime(Timestamp mailCreateTime) {
        this.mailCreateTime = mailCreateTime;
    }

    public Long getMailFileId() {
        return mailFileId;
    }

    public void setMailFileId(Long mailFileId) {
        this.mailFileId = mailFileId;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle == null ? null : mailTitle.trim();
    }

    public Long getMailType() {
        return mailType;
    }

    public void setMailType(Long mailType) {
        this.mailType = mailType;
    }

    public Long getMailInPushUserId() {
        return mailInPushUserId;
    }

    public void setMailInPushUserId(Long mailInPushUserId) {
        this.mailInPushUserId = mailInPushUserId;
    }

    public String getInReceiver() {
        return inReceiver;
    }

    public void setInReceiver(String inReceiver) {
        this.inReceiver = inReceiver == null ? null : inReceiver.trim();
    }

    public Long getMailStatusId() {
        return mailStatusId;
    }

    public void setMailStatusId(Long mailStatusId) {
        this.mailStatusId = mailStatusId;
    }

    public Long getMailNumberId() {
        return mailNumberId;
    }

    public void setMailNumberId(Long mailNumberId) {
        this.mailNumberId = mailNumberId;
    }

    public Integer getMailDel() {
        return mailDel;
    }

    public void setMailDel(Integer mailDel) {
        this.mailDel = mailDel;
    }

    public Integer getMailPush() {
        return mailPush;
    }

    public void setMailPush(Integer mailPush) {
        this.mailPush = mailPush;
    }

    public Integer getMailStar() {
        return mailStar;
    }

    public void setMailStar(Integer mailStar) {
        this.mailStar = mailStar;
    }
}