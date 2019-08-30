package com.ocms.entities;

import java.util.Date;

public class CheckEmail {
    private Long id;

    private String email;

    private String code;

    private Integer status;

    private Long createdBy;

    private Date createDate;

    private Long lastUpdatedBy;

    private Date lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public CheckEmail(String email, String code) {
        this.email = email;
        this.code = code;
    }

    public CheckEmail(Long id, String email, String code, Integer status, Long createdBy, Date createDate, Long lastUpdatedBy, Date lastUpdateDate) {
        this.id = id;
        this.email = email;
        this.code = code;
        this.status = status;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public CheckEmail() {
    }
}