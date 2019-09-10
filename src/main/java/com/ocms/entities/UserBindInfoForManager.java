package com.ocms.entities;

public class UserBindInfoForManager {
    private String key;
    private String number;
    private Long userId;
    private String username;

    public UserBindInfoForManager(String key, String number, Long userId, String username) {
        this.key = key;
        this.number = number;
        this.userId = userId;
        this.username = username;
    }

    public UserBindInfoForManager() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
