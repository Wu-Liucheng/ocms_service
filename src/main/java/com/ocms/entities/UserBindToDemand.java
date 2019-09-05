package com.ocms.entities;

import java.util.Date;

public class UserBindToDemand {
    private Long id;

    private Long demandId;

    private Long userId;

    private Boolean status;

    private Long createBy;

    private Date createDate;

    private Date lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
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

    public UserBindToDemand(Long id, Long demandId, Long userId, Boolean status, Long createBy, Date createDate, Date lastUpdateDate) {
        this.id = id;
        this.demandId = demandId;
        this.userId = userId;
        this.status = status;
        this.createBy = createBy;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }
}