package com.ocms.entities;

public class UserBindToDemandForChecker {

    private String key;

    /**
     * 编号，在数据库中无具体的定义
     */
    private String number;

    private Long userId;
    private Long demandId;
    private String username;
    private String demandName;

    public UserBindToDemandForChecker(String key, String number, Long userId, Long demandId, String username, String demandName) {
        this.key = key;
        this.number = number;
        this.userId = userId;
        this.demandId = demandId;
        this.username = username;
        this.demandName = demandName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }
}
