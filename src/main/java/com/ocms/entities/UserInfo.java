package com.ocms.entities;

import java.util.Date;

public class UserInfo {
    private Long id;

    private String loginName;

    private String password;

    private String email;

    private Long createdBy;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

    private Date createDate;

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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UserInfo(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public UserInfo(Long id, String loginName, String password, String email, Long createdBy, Long lastUpdateBy, Date lastUpdateDate, Date createDate) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.email = email;
        this.createdBy = createdBy;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.createDate = createDate;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdBy=" + createdBy +
                ", lastUpdateBy=" + lastUpdateBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", createDate=" + createDate +
                '}';
    }
}