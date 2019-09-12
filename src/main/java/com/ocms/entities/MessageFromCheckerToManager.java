package com.ocms.entities;

import java.sql.Timestamp;
import java.util.Date;

public class MessageFromCheckerToManager {
    private Long id;

    private Long demandId;

    private Long checkerId;

    private Long managerId;

    private String content;

    private Boolean isRead;

    private Boolean examineStatus;

    private Date createDate;

    private Demand demand;

    private Checker checker;

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
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

    public Long getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(Long checkerId) {
        this.checkerId = checkerId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(Boolean examineStatus) {
        this.examineStatus = examineStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public MessageFromCheckerToManager(Long id, Long demandId, Long checkerId, Long managerId, String content, Boolean isRead, Boolean examineStatus, Date createDate, Demand demand, Checker checker) {
        this.id = id;
        this.demandId = demandId;
        this.checkerId = checkerId;
        this.managerId = managerId;
        this.content = content;
        this.isRead = isRead;
        this.examineStatus = examineStatus;
        this.createDate = createDate;
        this.demand = demand;
        this.checker = checker;
    }
    public MessageFromCheckerToManager(Long id, Long demandId, Long checkerId, Long managerId, String content, Boolean isRead, Boolean examineStatus, Timestamp createDate, Demand demand, Checker checker) {
        this.id = id;
        this.demandId = demandId;
        this.checkerId = checkerId;
        this.managerId = managerId;
        this.content = content;
        this.isRead = isRead;
        this.examineStatus = examineStatus;
        this.createDate = createDate;
        this.demand = demand;
        this.checker = checker;
    }

    public MessageFromCheckerToManager() {
    }
}