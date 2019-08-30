package com.ocms.entities;

import java.util.Date;

public class Manager {
    private Long id;

    private String loginName;

    private String password;

    private String email;

    private String mobile;

    private Long clientId;

    private String name;

    private Long createdBy;

    private Long lastUpdateBy;

    private Date createDate;

    private Date lastUpdateDate;

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
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Manager() {
    }

    public Manager(Long id, String loginName, String password, String email, String mobile, Long clientId, String name, Long createdBy, Long lastUpdateBy, Date createDate, Date lastUpdateDate) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.clientId = clientId;
        this.name = name;
        this.createdBy = createdBy;
        this.lastUpdateBy = lastUpdateBy;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }
}