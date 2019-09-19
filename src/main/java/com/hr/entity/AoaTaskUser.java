package com.hr.entity;

import java.io.Serializable;

public class AoaTaskUser implements Serializable {
    private Long pkId;

    private Long statusId;

    private Long taskId;

    private Long taskReciveUserId;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTaskReciveUserId() {
        return taskReciveUserId;
    }

    public void setTaskReciveUserId(Long taskReciveUserId) {
        this.taskReciveUserId = taskReciveUserId;
    }
}