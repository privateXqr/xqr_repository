package com.hr.entity;

import java.io.Serializable;

public class AoaLoveDiscussUserKey implements Serializable {
    private Long discussId;

    private Long userId;

    public Long getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Long discussId) {
        this.discussId = discussId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}