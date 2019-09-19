package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AoaDiscussList implements Serializable {
    private Long discussId;

    private Integer attachmentId;

    private String content;

    private Timestamp createTime;

    private Long statusId;

    private String title;

    private Long typeId;

    private Integer visitNum;

    private Long discussUserId;

    private Long voteId;

    private Timestamp modifyTime;

    public Long getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Long discussId) {
        this.discussId = discussId;
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public Long getDiscussUserId() {
        return discussUserId;
    }

    public void setDiscussUserId(Long discussUserId) {
        this.discussUserId = discussUserId;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}