package com.ocms.entities;

public class Consultant {
    private String key;
    private Long id;
    private String name;
    private String goodAt;
    private String mobile;
    private String employYears;
    private String email;
    private String estimateLevel;
    private String employNumber;
    private String planDate;
    private String sex;
    private String degree;

    public Consultant(String key, Long id, String name, String goodAt, String phone, String employYears, String email, String estimateLevel, String employNumber, String planDate, String sex, String degree) {
        this.key = key;
        this.id = id;
        this.name = name;
        this.goodAt = goodAt;
        this.mobile = phone;
        this.employYears = employYears;
        this.email = email;
        this.estimateLevel = estimateLevel;
        this.employNumber = employNumber;
        this.planDate = planDate;
        this.sex = sex;
        this.degree = degree;
    }

    public Consultant() {
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "key='" + key + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", goodAt='" + goodAt + '\'' +
                ", mobile='" + mobile + '\'' +
                ", employYears='" + employYears + '\'' +
                ", email='" + email + '\'' +
                ", estimateLevel='" + estimateLevel + '\'' +
                ", employNumber='" + employNumber + '\'' +
                ", planDate='" + planDate + '\'' +
                ", sex='" + sex + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(String goodAt) {
        this.goodAt = goodAt;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmployYears() {
        return employYears;
    }

    public void setEmployYears(String employYears) {
        this.employYears = employYears;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstimateLevel() {
        return estimateLevel;
    }

    public void setEstimateLevel(String estimateLevel) {
        this.estimateLevel = estimateLevel;
    }

    public String getEmployNumber() {
        return employNumber;
    }

    public void setEmployNumber(String employNumber) {
        this.employNumber = employNumber;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
