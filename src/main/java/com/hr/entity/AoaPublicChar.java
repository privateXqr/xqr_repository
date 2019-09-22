package com.hr.entity;

public class AoaPublicChar {
    private Integer charId;

    private Integer charStatusId;

    private String charName;

    private String charType;

    private Integer isTop;

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getCharStatusId() {
        return charStatusId;
    }

    public void setCharStatusId(Integer charStatusId) {
        this.charStatusId = charStatusId;
    }

    public Integer getCharId() {
        return charId;
    }

    public void setCharId(Integer charId) {
        this.charId = charId;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName == null ? null : charName.trim();
    }

    public String getCharType() {
        return charType;
    }

    public void setCharType(String charType) {
        this.charType = charType == null ? null : charType.trim();
    }
}