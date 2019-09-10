package com.ocms.entities;

import java.sql.Timestamp;
import java.util.Date;

public class UserBindToDemand {
    private Long id;

    private Long demandId;

    private Long userId;

    private Boolean status;

    private Long createBy;

    private Date createDate;

    private Date lastUpdateDate;

    private Resume resume;

    private Demand demand;

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public UserBindToDemand(Long id, Long demandId, Long userId, Boolean status, Long createBy, Date createDate, Date lastUpdateDate, Resume resume, Demand demand) {
        this.id = id;
        this.demandId = demandId;
        this.userId = userId;
        this.status = status;
        this.createBy = createBy;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.resume = resume;
        this.demand = demand;
    }

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

    public UserBindToDemand(Long id, Long demandId, Long userId, Boolean status, Long createBy, Timestamp createDate, Timestamp lastUpdateDate) {
        this.id = id;
        this.demandId = demandId;
        this.userId = userId;
        this.status = status;
        this.createBy = createBy;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public UserBindToDemand() {
    }

    public UserBindToDemand(Long demandId, Long userId) {
        this.demandId = demandId;
        this.userId = userId;
    }
}