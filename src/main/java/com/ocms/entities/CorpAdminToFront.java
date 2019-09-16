package com.ocms.entities;

public class CorpAdminToFront {
    private String key;
    private String number;
    private Long id;
    private String loginName;
    private String name;
    private String email;
    private String mobile;
    private Long clientId;
    private String clientName;

    public CorpAdminToFront() {
    }

    public CorpAdminToFront(String key, String number, Long id, String loginName, String name, String email, String mobile, Long clientId, String clientName) {
        this.key = key;
        this.number = number;
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.clientId = clientId;
        this.clientName = clientName;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
