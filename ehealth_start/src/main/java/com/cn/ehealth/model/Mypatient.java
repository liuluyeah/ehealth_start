package com.cn.ehealth.model;

public class Mypatient {
    private Integer idmypatient;

    private String name;

    private String classification;

    private String time;

    private String sugar;

    private String fat;

    private String bmi;

    private String waisthipratio;

    private String divide;

    private String medicine;

    public Integer getIdmypatient() {
        return idmypatient;
    }

    public void setIdmypatient(Integer idmypatient) {
        this.idmypatient = idmypatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar == null ? null : sugar.trim();
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat == null ? null : fat.trim();
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi == null ? null : bmi.trim();
    }

    public String getWaisthipratio() {
        return waisthipratio;
    }

    public void setWaisthipratio(String waisthipratio) {
        this.waisthipratio = waisthipratio == null ? null : waisthipratio.trim();
    }

    public String getDivide() {
        return divide;
    }

    public void setDivide(String divide) {
        this.divide = divide == null ? null : divide.trim();
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine == null ? null : medicine.trim();
    }
}