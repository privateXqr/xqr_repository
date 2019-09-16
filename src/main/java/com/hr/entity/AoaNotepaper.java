package com.hr.entity;

import java.util.Date;

public class AoaNotepaper {
    private Long notepaperId;

    private String concent;

    private Date createTime;

    private String title;

    private Long notepaperUserId;

    public Long getNotepaperId() {
        return notepaperId;
    }

    public void setNotepaperId(Long notepaperId) {
        this.notepaperId = notepaperId;
    }

    public String getConcent() {
        return concent;
    }

    public void setConcent(String concent) {
        this.concent = concent == null ? null : concent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getNotepaperUserId() {
        return notepaperUserId;
    }

    public void setNotepaperUserId(Long notepaperUserId) {
        this.notepaperUserId = notepaperUserId;
    }
}