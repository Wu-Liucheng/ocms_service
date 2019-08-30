package com.ocms.entities;

import java.util.Date;

public class Demand {
    private Long id;

    private String name;

    private String number;

    private Integer status;

    private String description;

    private Long consultantRole;

    private Long type;

    private String modular;

    private String employTime;

    private String workAddress;

    private Boolean isBoard;

    private Date startDate;

    private String cycle;

    private String duration;

    private Integer priceFluctuation;

    private Integer price;

    private String priceUnit;

    private Long examineId;

    private Integer examineStatus;

    private Long processNodeId;

    private Long objectId;

    private Date releaseTime;

    private Long createdBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

    private Project project;

    public Boolean getBoard() {
        return isBoard;
    }

    public void setBoard(Boolean board) {
        isBoard = board;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getConsultantRole() {
        return consultantRole;
    }

    public void setConsultantRole(Long consultantRole) {
        this.consultantRole = consultantRole;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular == null ? null : modular.trim();
    }

    public String getEmployTime() {
        return employTime;
    }

    public void setEmployTime(String employTime) {
        this.employTime = employTime == null ? null : employTime.trim();
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress == null ? null : workAddress.trim();
    }

    public Boolean getIsBoard() {
        return isBoard;
    }

    public void setIsBoard(Boolean isBoard) {
        this.isBoard = isBoard;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle == null ? null : cycle.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit == null ? null : priceUnit.trim();
    }

    public Long getExamineId() {
        return examineId;
    }

    public void setExamineId(Long examineId) {
        this.examineId = examineId;
    }

    public Integer getExamineStatus() {
        return examineStatus;
    }

    public void setExamineStatus(Integer examineStatus) {
        this.examineStatus = examineStatus;
    }

    public Long getProcessNodeId() {
        return processNodeId;
    }

    public void setProcessNodeId(Long processNodeId) {
        this.processNodeId = processNodeId;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
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

    public Integer getPriceFluctuation() {
        return priceFluctuation;
    }

    public void setPriceFluctuation(Integer priceFluctuation) {
        this.priceFluctuation = priceFluctuation;
    }

    public Demand() {
    }

    public Demand(Long id, String name, String number, Integer status, String description, Long consultantRole, Long type, String modular, String employTime, String workAddress, Boolean isBoard, Date startDate, String cycle, String duration, Integer price, String priceUnit, Long examineId, Integer examineStatus, Long processNodeId, Long objectId, Date releaseTime, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.status = status;
        this.description = description;
        this.consultantRole = consultantRole;
        this.type = type;
        this.modular = modular;
        this.employTime = employTime;
        this.workAddress = workAddress;
        this.isBoard = isBoard;
        this.startDate = startDate;
        this.cycle = cycle;
        this.duration = duration;
        this.price = price;
        this.priceUnit = priceUnit;
        this.examineId = examineId;
        this.examineStatus = examineStatus;
        this.processNodeId = processNodeId;
        this.objectId = objectId;
        this.releaseTime = releaseTime;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Demand(Long id, String name, String number, Integer status, String description, Long consultantRole, Long type, String modular, String employTime, String workAddress, Boolean isBoard, Date startDate, String cycle, String duration, Integer price, String priceUnit, Long examineId, Integer examineStatus, Long processNodeId, Long objectId, Date releaseTime, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate, Project project) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.status = status;
        this.description = description;
        this.consultantRole = consultantRole;
        this.type = type;
        this.modular = modular;
        this.employTime = employTime;
        this.workAddress = workAddress;
        this.isBoard = isBoard;
        this.startDate = startDate;
        this.cycle = cycle;
        this.duration = duration;
        this.price = price;
        this.priceUnit = priceUnit;
        this.examineId = examineId;
        this.examineStatus = examineStatus;
        this.processNodeId = processNodeId;
        this.objectId = objectId;
        this.releaseTime = releaseTime;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.project = project;
    }

    public Demand(Long id, String name, String number, Integer status, String description, Long consultantRole, Long type, String modular, String employTime, String workAddress, Boolean isBoard, Date startDate, String cycle, String duration, Integer priceFluctuation, Integer price, String priceUnit, Long examineId, Integer examineStatus, Long processNodeId, Long objectId, Date releaseTime, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate, Project project) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.status = status;
        this.description = description;
        this.consultantRole = consultantRole;
        this.type = type;
        this.modular = modular;
        this.employTime = employTime;
        this.workAddress = workAddress;
        this.isBoard = isBoard;
        this.startDate = startDate;
        this.cycle = cycle;
        this.duration = duration;
        this.priceFluctuation = priceFluctuation;
        this.price = price;
        this.priceUnit = priceUnit;
        this.examineId = examineId;
        this.examineStatus = examineStatus;
        this.processNodeId = processNodeId;
        this.objectId = objectId;
        this.releaseTime = releaseTime;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.project = project;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", consultantRole=" + consultantRole +
                ", type=" + type +
                ", modular='" + modular + '\'' +
                ", employTime='" + employTime + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", isBoard=" + isBoard +
                ", startDate=" + startDate +
                ", cycle='" + cycle + '\'' +
                ", duration='" + duration + '\'' +
                ", priceFluctuation=" + priceFluctuation +
                ", price=" + price +
                ", priceUnit='" + priceUnit + '\'' +
                ", examineId=" + examineId +
                ", examineStatus=" + examineStatus +
                ", processNodeId=" + processNodeId +
                ", objectId=" + objectId +
                ", releaseTime=" + releaseTime +
                ", createdBy=" + createdBy +
                ", createDate=" + createDate +
                ", lastUpdateBy=" + lastUpdateBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", project=" + project +
                '}';
    }
}