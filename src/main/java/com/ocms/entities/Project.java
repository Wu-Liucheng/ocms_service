package com.ocms.entities;

import java.util.Date;

public class Project {
    private Long id;

    private String name;

    private String number;

    private Long managerId;

    private Date startDate;

    private Date endDate;

    private Integer status;

    private Long clientId;

    private Long createdBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

    private Client client;

    private Manager manager;

    public Project(Long id, String name, String number, Long managerId, Date startDate, Date endDate, Integer status, Long clientId, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate, Client client, Manager manager) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.managerId = managerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.clientId = clientId;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.client = client;
        this.manager = manager;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Project() {
    }

    public Project(Long id, String name, String number, Long managerId, Date startDate, Date endDate, Integer status, Long clientId, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.managerId = managerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.clientId = clientId;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", managerId=" + managerId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", clientId=" + clientId +
                ", createdBy=" + createdBy +
                ", createDate=" + createDate +
                ", lastUpdateBy=" + lastUpdateBy +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

    public Project(Long id, String name, String number, Long managerId, Date startDate, Date endDate, Integer status, Long clientId, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate, Client client) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.managerId = managerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.clientId = clientId;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}