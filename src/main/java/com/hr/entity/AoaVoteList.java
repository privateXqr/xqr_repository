package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AoaVoteList implements Serializable {
    private Long voteId;

    private Timestamp endTime;

    private Integer selectone;

    private Timestamp startTime;

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Integer getSelectone() {
        return selectone;
    }

    public void setSelectone(Integer selectone) {
        this.selectone = selectone;
    }


}