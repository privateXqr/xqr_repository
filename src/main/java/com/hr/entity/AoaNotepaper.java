package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AoaNotepaper  implements Serializable {
    private Long notepaperId;

    private String concent;

    private Timestamp createTime;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
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