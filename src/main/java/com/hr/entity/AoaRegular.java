package com.hr.entity;

import java.io.Serializable;

public class AoaRegular implements Serializable {
    private Long regularId;

    private String advice;

    private String deficiency;

    private String dobetter;

    private String experience;

    private String personnelAdvice;

    private String pullulate;

    private String understand;

    private Long proId;

    private String managerAdvice;

    private Integer days;

    public Long getRegularId() {
        return regularId;
    }

    public void setRegularId(Long regularId) {
        this.regularId = regularId;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public String getDeficiency() {
        return deficiency;
    }

    public void setDeficiency(String deficiency) {
        this.deficiency = deficiency == null ? null : deficiency.trim();
    }

    public String getDobetter() {
        return dobetter;
    }

    public void setDobetter(String dobetter) {
        this.dobetter = dobetter == null ? null : dobetter.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public String getPersonnelAdvice() {
        return personnelAdvice;
    }

    public void setPersonnelAdvice(String personnelAdvice) {
        this.personnelAdvice = personnelAdvice == null ? null : personnelAdvice.trim();
    }

    public String getPullulate() {
        return pullulate;
    }

    public void setPullulate(String pullulate) {
        this.pullulate = pullulate == null ? null : pullulate.trim();
    }

    public String getUnderstand() {
        return understand;
    }

    public void setUnderstand(String understand) {
        this.understand = understand == null ? null : understand.trim();
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

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}