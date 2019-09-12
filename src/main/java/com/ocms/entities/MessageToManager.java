package com.ocms.entities;

public class MessageToManager {

    private String key;
    private String number;
    private Long id;
    private Long demandId;
    private Long checkerId;
    private String content;
    private Boolean isRead;
    private Boolean examineStatus;
    private String createDate;
    private String demandName;
    private String checkerName;

    public MessageToManager() {
    }

    public MessageToManager(String key, String number, Long id, Long demandId, Long checkerId, String content, Boolean isRead, Boolean examineStatus, String createDate, String demandName, String checkerName) {
        this.key = key;
        this.number = number;
        this.id = id;
        this.demandId = demandId;
        this.checkerId = checkerId;
        this.content = content;
        this.isRead = isRead;
        this.examineStatus = examineStatus;
        this.createDate = createDate;
        this.demandName = demandName;
        this.checkerName = checkerName;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Boolean getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(Boolean examineStatus) {
        this.examineStatus = examineStatus;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }
}
