package com.hr.entity;

import java.io.Serializable;

public class AoaLoveUser implements Serializable {
    private Long replyId;

    private Long userId;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}