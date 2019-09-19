package com.hr.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class AoaStay implements Serializable {
    private Long stayId;

    private Integer day;

    private String hotelName;

    private Timestamp leaveTime;

    private String stayCity;

    private Double stayMoney;

    private Timestamp stayTime;

    private Long evemoneyId;

    private Long userName;

    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public Timestamp getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getStayCity() {
        return stayCity;
    }

    public void setStayCity(String stayCity) {
        this.stayCity = stayCity == null ? null : stayCity.trim();
    }

    public Double getStayMoney() {
        return stayMoney;
    }

    public void setStayMoney(Double stayMoney) {
        this.stayMoney = stayMoney;
    }

    public Timestamp getStayTime() {
        return stayTime;
    }

    public void setStayTime(Timestamp stayTime) {
        this.stayTime = stayTime;
    }

    public Long getEvemoneyId() {
        return evemoneyId;
    }

    public void setEvemoneyId(Long evemoneyId) {
        this.evemoneyId = evemoneyId;
    }

    public Long getUserName() {
        return userName;
    }

    public void setUserName(Long userName) {
        this.userName = userName;
    }
}