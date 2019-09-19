package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AoaTaskLogger  implements Serializable {
    private Long loggerId;

    private Timestamp createTime;

    private String loggerTicking;

    private Long taskId;

    private String username;

    private Integer loggerStatusid;

    public Long getLoggerId() {
        return loggerId;
    }

    public void setLoggerId(Long loggerId) {
        this.loggerId = loggerId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getLoggerTicking() {
        return loggerTicking;
    }

    public void setLoggerTicking(String loggerTicking) {
        this.loggerTicking = loggerTicking == null ? null : loggerTicking.trim();
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getLoggerStatusid() {
        return loggerStatusid;
    }

    public void setLoggerStatusid(Integer loggerStatusid) {
        this.loggerStatusid = loggerStatusid;
    }
}