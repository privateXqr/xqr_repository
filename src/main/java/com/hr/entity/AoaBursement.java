package com.hr.entity;

import java.sql.Date;

public class AoaBursement {
    private Long bursementId;

    private Double allMoney;

    private Integer allinvoices;

    private Date burseTime;

    private String financialAdvice;

    private String managerAdvice;

    private String name;

    private Long typeId;

    private Long operationName;

    private Long proId;

    private Long userName;

    public Long getBursementId() {
        return bursementId;
    }

    public void setBursementId(Long bursementId) {
        this.bursementId = bursementId;
    }

    public Double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }

    public Integer getAllinvoices() {
        return allinvoices;
    }

    public void setAllinvoices(Integer allinvoices) {
        this.allinvoices = allinvoices;
    }

    public Date getBurseTime() {
        return burseTime;
    }

    public void setBurseTime(Date burseTime) {
        this.burseTime = burseTime;
    }

    public String getFinancialAdvice() {
        return financialAdvice;
    }

    public void setFinancialAdvice(String financialAdvice) {
        this.financialAdvice = financialAdvice == null ? null : financialAdvice.trim();
    }

    public String getManagerAdvice() {
        return managerAdvice;
    }

    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getOperationName() {
        return operationName;
    }

    public void setOperationName(Long operationName) {
        this.operationName = operationName;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Long getUserName() {
        return userName;
    }

    public void setUserName(Long userName) {
        this.userName = userName;
    }
}