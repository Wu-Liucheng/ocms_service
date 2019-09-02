package com.ocms.entities;

public class SignUpInfoForChecker {
    private String key;
    private Long demandId;
    private String name;
    private String number;
    private String modular;
    private String employTime;
    private String workAddress;
    private String startDate;
    private String cycle;
    private Integer price;
    private String priceUnit;
    private Long objectId;
    private Long userId;
    private String username;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular;
    }

    public String getEmployTime() {
        return employTime;
    }

    public void setEmployTime(String employTime) {
        this.employTime = employTime;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SignUpInfoForChecker(String key, Long demandId, String name, String number, String modular, String employTime, String workAddress, String startDate, String cycle, Integer price, String priceUnit, Long objectId, Long userId, String username) {
        this.key = key;
        this.demandId = demandId;
        this.name = name;
        this.number = number;
        this.modular = modular;
        this.employTime = employTime;
        this.workAddress = workAddress;
        this.startDate = startDate;
        this.cycle = cycle;
        this.price = price;
        this.priceUnit = priceUnit;
        this.objectId = objectId;
        this.userId = userId;
        this.username = username;
    }
}
