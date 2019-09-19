package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AoaTaskList implements Serializable {
    private Long taskId;

    private String comment;

    private Timestamp endTime;

    private Integer isCancel;

    private Integer isTop;

    private Timestamp modifyTime;

    private Timestamp publishTime;

    private Timestamp starTime;

    private Integer statusId;

    private String taskDescribe;

    private String ticking;

    private String title;

    private Long typeId;

    private Long taskPushUserId;

    private String reciverlist;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public Timestamp getStarTime() {
        return starTime;
    }

    public void setStarTime(Timestamp starTime) {
        this.starTime = starTime;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getTaskDescribe() {
        return taskDescribe;
    }

    public void setTaskDescribe(String taskDescribe) {
        this.taskDescribe = taskDescribe == null ? null : taskDescribe.trim();
    }

    public String getTicking() {
        return ticking;
    }

    public void setTicking(String ticking) {
        this.ticking = ticking == null ? null : ticking.trim();
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

    public Long getTaskPushUserId() {
        return taskPushUserId;
    }

    public void setTaskPushUserId(Long taskPushUserId) {
        this.taskPushUserId = taskPushUserId;
    }

    public String getReciverlist() {
        return reciverlist;
    }

    public void setReciverlist(String reciverlist) {
        this.reciverlist = reciverlist == null ? null : reciverlist.trim();
    }
}