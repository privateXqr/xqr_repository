package com.hr.entity;

public class AoaResign {
    private Long resignId;

    private String financialAdvice;

    private Boolean isFinish;

    private String nofinish;

    private String personnelAdvice;

    private String suggest;

    private Long handUser;

    private Long proId;

    private String managerAdvice;

    public Long getResignId() {
        return resignId;
    }

    public void setResignId(Long resignId) {
        this.resignId = resignId;
    }

    public String getFinancialAdvice() {
        return financialAdvice;
    }

    public void setFinancialAdvice(String financialAdvice) {
        this.financialAdvice = financialAdvice == null ? null : financialAdvice.trim();
    }

    public Boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public String getNofinish() {
        return nofinish;
    }

    public void setNofinish(String nofinish) {
        this.nofinish = nofinish == null ? null : nofinish.trim();
    }

    public String getPersonnelAdvice() {
        return personnelAdvice;
    }

    public void setPersonnelAdvice(String personnelAdvice) {
        this.personnelAdvice = personnelAdvice == null ? null : personnelAdvice.trim();
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest == null ? null : suggest.trim();
    }

    public Long getHandUser() {
        return handUser;
    }

    public void setHandUser(Long handUser) {
        this.handUser = handUser;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getManagerAdvice() {
        return managerAdvice;
    }

    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
    }
}