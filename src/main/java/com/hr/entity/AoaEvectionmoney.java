package com.hr.entity;

public class AoaEvectionmoney {
    private Long evectionmoneyId;

    private String financialAdvice;

    private String managerAdvice;

    private Double money;

    private String name;

    private Long proId;

    private Integer pro;

    public Long getEvectionmoneyId() {
        return evectionmoneyId;
    }

    public void setEvectionmoneyId(Long evectionmoneyId) {
        this.evectionmoneyId = evectionmoneyId;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Integer getPro() {
        return pro;
    }

    public void setPro(Integer pro) {
        this.pro = pro;
    }
}