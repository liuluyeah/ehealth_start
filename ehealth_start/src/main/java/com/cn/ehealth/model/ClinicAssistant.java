package com.cn.ehealth.model;

public class ClinicAssistant {
    private Integer idmenzhen;

    private String name;

    private String time;

    private String mainreason;

    private String height;

    private String weigtht;

    private String bloodpressure;

    private String waist;

    private String hip;

    private String classification;

    private String divide;

    public Integer getIdmenzhen() {
        return idmenzhen;
    }

    public void setIdmenzhen(Integer idmenzhen) {
        this.idmenzhen = idmenzhen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getMainreason() {
        return mainreason;
    }

    public void setMainreason(String mainreason) {
        this.mainreason = mainreason == null ? null : mainreason.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeigtht() {
        return weigtht;
    }

    public void setWeigtht(String weigtht) {
        this.weigtht = weigtht == null ? null : weigtht.trim();
    }

    public String getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(String bloodpressure) {
        this.bloodpressure = bloodpressure == null ? null : bloodpressure.trim();
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist == null ? null : waist.trim();
    }

    public String getHip() {
        return hip;
    }

    public void setHip(String hip) {
        this.hip = hip == null ? null : hip.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public String getDivide() {
        return divide;
    }

    public void setDivide(String divide) {
        this.divide = divide == null ? null : divide.trim();
    }
}