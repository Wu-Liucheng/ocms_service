package com.ocms.entities;

import java.util.Date;

public class SignUpInfo extends SignUpInfoKey {
    private Integer status;

    private Long createdBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

    private Demand demand;

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
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

    public SignUpInfo(Long userId, Long demandId) {
        super(userId, demandId);
    }

    public SignUpInfo() {
    }

    public SignUpInfo(Long userId, Long demandId, Integer status, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate) {
        super(userId, demandId);
        this.status = status;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public SignUpInfo(Integer status, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate) {
        this.status = status;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }
}