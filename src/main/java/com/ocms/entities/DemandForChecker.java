package com.ocms.entities;

import java.util.Date;

public class DemandForChecker {
    private String key;

    private Long id;

    private String name;

    private String number;

    private String status;

    private String modular;

    private String employTime;

    private String workAddress;

    private String startDate;

    private String cycle;

    private Integer price;

    private String priceUnit;

    private Long objectId;

    public DemandForChecker(String key, Long id, String name, String number, String status, String modular, String employTime, String workAddress, String startDate, String cycle, Integer price, String priceUnit, Long objectId) {
        this.key = key;
        this.id = id;
        this.name = name;
        this.number = number;
        this.status = status;
        this.modular = modular;
        this.employTime = employTime;
        this.workAddress = workAddress;
        this.startDate = startDate;
        this.cycle = cycle;
        this.price = price;
        this.priceUnit = priceUnit;
        this.objectId = objectId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
