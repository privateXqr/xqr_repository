package com.hr.entity;

import java.sql.Date;

public class AoaProcessList {
    private Long processId;

    private Date applyTime;

    private Long deeplyId;

    private Date endTime;

    private String processDes;

    private String processName;

    private Integer procseeDays;

    private Integer isChecked;

    private Date startTime;

    private Long statusId;

    private String typeName;

    private Long proFileId;

    private Long processUserId;

    private String shenuser;

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Long getDeeplyId() {
        return deeplyId;
    }

    public void setDeeplyId(Long deeplyId) {
        this.deeplyId = deeplyId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProcessDes() {
        return processDes;
    }

    public void setProcessDes(String processDes) {
        this.processDes = processDes == null ? null : processDes.trim();
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public Integer getProcseeDays() {
        return procseeDays;
    }

    public void setProcseeDays(Integer procseeDays) {
        this.procseeDays = procseeDays;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Long getProFileId() {
        return proFileId;
    }

    public void setProFileId(Long proFileId) {
        this.proFileId = proFileId;
    }

    public Long getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Long processUserId) {
        this.processUserId = processUserId;
    }

    public String getShenuser() {
        return shenuser;
    }

    public void setShenuser(String shenuser) {
        this.shenuser = shenuser == null ? null : shenuser.trim();
    }
}