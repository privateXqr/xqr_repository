package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AoaPlanList implements Serializable {
    private Timestamp createTime;

    private Timestamp endTime;

    private String label;

    private String planComment;

    private String planContent;

    private String planSummary;

    private Long statusId;

    private String title;

    private Long typeId;

    private Long planUserId;

    private Long attachId;

    private Long planId;

    private Timestamp startTime;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }


    public Long getPlanId() {
        return planId;
    }


    public void setPlanId(Long planId) {
        this.planId = planId;
    }


    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getPlanComment() {
        return planComment;
    }

    public void setPlanComment(String planComment) {
        this.planComment = planComment == null ? null : planComment.trim();
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public String getPlanSummary() {
        return planSummary;
    }

    public void setPlanSummary(String planSummary) {
        this.planSummary = planSummary == null ? null : planSummary.trim();
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

    public Long getPlanUserId() {
        return planUserId;
    }

    public void setPlanUserId(Long planUserId) {
        this.planUserId = planUserId;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }
}