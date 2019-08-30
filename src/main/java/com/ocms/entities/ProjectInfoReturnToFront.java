package com.ocms.entities;

public class ProjectInfoReturnToFront {
    private String key;
    private Long id;
    private String number;
    private String name;
    private String managerName;
    private String status;
    private String startDate;
    private String endDate;
    private String clientName;

    public ProjectInfoReturnToFront(String key, Long id, String number, String name, String managerName, String status, String startDate, String endDate, String clientName) {
        this.key = key;
        this.id = id;
        this.number = number;
        this.name = name;
        this.managerName = managerName;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientName = clientName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "ProjectInfoReturnToFront{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", status='" + status + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
