package com.hr.entity;

import java.sql.Date;

public class AoaPlanListKey {
    private Long planId;

    private Date startTime;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}