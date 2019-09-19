package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class AoaDetailsburse implements Serializable {
    private Long detailsburseId;

    private String descript;

    private Double detailmoney;

    private Integer invoices;

    private Timestamp produceTime;

    private String subject;

    private Long bursmentId;

    public Long getDetailsburseId() {
        return detailsburseId;
    }

    public void setDetailsburseId(Long detailsburseId) {
        this.detailsburseId = detailsburseId;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }

    public Double getDetailmoney() {
        return detailmoney;
    }

    public void setDetailmoney(Double detailmoney) {
        this.detailmoney = detailmoney;
    }

    public Integer getInvoices() {
        return invoices;
    }

    public void setInvoices(Integer invoices) {
        this.invoices = invoices;
    }

    public Timestamp getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Timestamp produceTime) {
        this.produceTime = produceTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Long getBursmentId() {
        return bursmentId;
    }

    public void setBursmentId(Long bursmentId) {
        this.bursmentId = bursmentId;
    }
}