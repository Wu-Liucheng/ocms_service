package com.ocms.entities;

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
}