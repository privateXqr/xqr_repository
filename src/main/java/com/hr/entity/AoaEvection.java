package com.hr.entity;

public class AoaEvection {
    private Long evectionId;

    private Long typeId;

    private Long proId;

    private String personnelAdvice;

    private String managerAdvice;

    public Long getEvectionId() {
        return evectionId;
    }

    public void setEvectionId(Long evectionId) {
        this.evectionId = evectionId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getPersonnelAdvice() {
        return personnelAdvice;
    }

    public void setPersonnelAdvice(String personnelAdvice) {
        this.personnelAdvice = personnelAdvice == null ? null : personnelAdvice.trim();
    }

    public String getManagerAdvice() {
        return managerAdvice;
    }

    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
    }
}