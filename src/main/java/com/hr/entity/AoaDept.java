package com.hr.entity;

import java.sql.Date;

public class AoaDept {
    private Long deptId;

    private String deptAddr;

    private String deptFax;

    private String deptName;

    private String deptTel;

    private String email;

    private Long deptmanager;

    private Date endTime;

    private Date startTime;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr == null ? null : deptAddr.trim();
    }

    public String getDeptFax() {
        return deptFax;
    }

    public void setDeptFax(String deptFax) {
        this.deptFax = deptFax == null ? null : deptFax.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptTel() {
        return deptTel;
    }

    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel == null ? null : deptTel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getDeptmanager() {
        return deptmanager;
    }

    public void setDeptmanager(Long deptmanager) {
        this.deptmanager = deptmanager;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}