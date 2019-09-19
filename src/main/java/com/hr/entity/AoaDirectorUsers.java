package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class AoaDirectorUsers implements Serializable {
    private Long directorUsersId;

    private String catelogName;

    private Integer isHandle;

    private Long directorId;

    private Long userId;

    private Long shareUserId;

    private Timestamp sharetime;

    public Long getDirectorUsersId() {
        return directorUsersId;
    }

    public void setDirectorUsersId(Long directorUsersId) {
        this.directorUsersId = directorUsersId;
    }

    public String getCatelogName() {
        return catelogName;
    }

    public void setCatelogName(String catelogName) {
        this.catelogName = catelogName == null ? null : catelogName.trim();
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Timestamp getSharetime() {
        return sharetime;
    }

    public void setSharetime(Timestamp sharetime) {
        this.sharetime = sharetime;
    }
}