package com.ocms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Resume {
    private Long id;

    private String mobile;

    private String idNumber;

    private String name;

    private String email;

    private String qq;

    private String employYears;

    private String goodAt;

    private String estimateLevel;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date communicateDate;

    private Boolean isBeingUsed;

    private String communicatePerson;

    private String employNumber;

    private Integer idealSalary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private String degree;

    private String priceUnit;

    private String school;

    private Boolean sex;

    private String location;

    private String otherInfo;

    private Long createdBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmployYears() {
        return employYears;
    }

    public void setEmployYears(String employYears) {
        this.employYears = employYears == null ? null : employYears.trim();
    }

    public String getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(String goodAt) {
        this.goodAt = goodAt == null ? null : goodAt.trim();
    }

    public String getEstimateLevel() {
        return estimateLevel;
    }

    public void setEstimateLevel(String estimateLevel) {
        this.estimateLevel = estimateLevel == null ? null : estimateLevel.trim();
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getCommunicateDate() {
        return communicateDate;
    }

    public void setCommunicateDate(Date communicateDate) {
        this.communicateDate = communicateDate;
    }

    public Boolean getIsBeingUsed() {
        return isBeingUsed;
    }

    public void setIsBeingUsed(Boolean isBeingUsed) {
        this.isBeingUsed = isBeingUsed;
    }

    public String getCommunicatePerson() {
        return communicatePerson;
    }

    public void setCommunicatePerson(String communicatePerson) {
        this.communicatePerson = communicatePerson == null ? null : communicatePerson.trim();
    }

    public String getEmployNumber() {
        return employNumber;
    }

    public void setEmployNumber(String employNumber) {
        this.employNumber = employNumber == null ? null : employNumber.trim();
    }

    public Integer getIdealSalary() {
        return idealSalary;
    }

    public void setIdealSalary(Integer idealSalary) {
        this.idealSalary = idealSalary;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit == null ? null : priceUnit.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo == null ? null : otherInfo.trim();
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Resume(Long id, String mobile, String idNumber, String name, String email, String qq, String employYears, String goodAt, String estimateLevel, Date planDate, Date communicateDate, Boolean isBeingUsed, String communicatePerson, String employNumber, Integer idealSalary, Date birth, String degree, String priceUnit, String school, Boolean sex, String location, String otherInfo, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate) {
        this.id = id;
        this.mobile = mobile;
        this.idNumber = idNumber;
        this.name = name;
        this.email = email;
        this.qq = qq;
        this.employYears = employYears;
        this.goodAt = goodAt;
        this.estimateLevel = estimateLevel;
        this.planDate = planDate;
        this.communicateDate = communicateDate;
        this.isBeingUsed = isBeingUsed;
        this.communicatePerson = communicatePerson;
        this.employNumber = employNumber;
        this.idealSalary = idealSalary;
        this.birth = birth;
        this.degree = degree;
        this.priceUnit = priceUnit;
        this.school = school;
        this.sex = sex;
        this.location = location;
        this.otherInfo = otherInfo;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Resume() {
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", employYears='" + employYears + '\'' +
                ", goodAt='" + goodAt + '\'' +
                ", estimateLevel='" + estimateLevel + '\'' +
                ", planDate=" + planDate +
                ", communicateDate=" + communicateDate +
                ", isBeingUsed=" + isBeingUsed +
                ", communicatePerson='" + communicatePerson + '\'' +
                ", employNumber='" + employNumber + '\'' +
                ", idealSalary=" + idealSalary +
                ", birth=" + birth +
                ", degree='" + degree + '\'' +
                ", priceUnit='" + priceUnit + '\'' +
                ", school='" + school + '\'' +
                ", sex=" + sex +
                ", location='" + location + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                ", createdBy=" + createdBy +
                ", createDate=" + createDate +
                ", lastUpdateBy=" + lastUpdateBy +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

    public Resume(Long id, String mobile, String name, String email, String employYears, String estimateLevel, Date planDate, Date communicateDate, String communicatePerson, String employNumber, String location, String otherInfo) {
        this.id = id;
        this.mobile = mobile;
        this.name = name;
        this.email = email;
        this.employYears = employYears;
        this.estimateLevel = estimateLevel;
        this.planDate = planDate;
        this.communicateDate = communicateDate;
        this.communicatePerson = communicatePerson;
        this.employNumber = employNumber;
        this.location = location;
        this.otherInfo = otherInfo;
    }

    public Resume(Long id, Boolean isBeingUsed) {
        this.id = id;
        this.isBeingUsed = isBeingUsed;
    }

    public Resume(Long id, Date planDate, Boolean isBeingUsed) {
        this.id = id;
        this.planDate = planDate;
        this.isBeingUsed = isBeingUsed;
    }
}