package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AoaProcessList implements Serializable {
    private Long processId;

    private Timestamp applyTime;

    private Long deeplyId;

    private Timestamp endTime;

    private String processDes;

    private String processName;

    private Integer procseeDays;

    private Integer isChecked;

    private Timestamp startTime;

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

    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    public Long getDeeplyId() {
        return deeplyId;
    }

    public void setDeeplyId(Long deeplyId) {
        this.deeplyId = deeplyId;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
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

    @Override
    public String toString() {
        return "AoaProcessList{" +
                "processId=" + processId +
                ", applyTime=" + applyTime +
                ", deeplyId=" + deeplyId +
                ", endTime=" + endTime +
                ", processDes='" + processDes + '\'' +
                ", processName='" + processName + '\'' +
                ", procseeDays=" + procseeDays +
                ", isChecked=" + isChecked +
                ", startTime=" + startTime +
                ", statusId=" + statusId +
                ", typeName='" + typeName + '\'' +
                ", proFileId=" + proFileId +
                ", processUserId=" + processUserId +
                ", shenuser='" + shenuser + '\'' +
                '}';
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
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