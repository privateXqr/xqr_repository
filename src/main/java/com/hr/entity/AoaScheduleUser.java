package com.hr.entity;

import java.io.Serializable;

public class AoaScheduleUser implements Serializable {
    private Long rcid;

    private Long userId;

    public Long getRcid() {
        return rcid;
    }

    public void setRcid(Long rcid) {
        this.rcid = rcid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}