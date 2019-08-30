package com.ocms.entities;

import java.util.Objects;

public class LatestDemandInfo {

    private Long id;

    private String projectName;

    private String jobName;

    private String salary;

    private String priceUnit;

    private String company;

    public LatestDemandInfo() {
    }

    public LatestDemandInfo(Long id, String projectName, String jobName, String salary, String priceUnit, String company) {
        this.id = id;
        this.projectName = projectName;
        this.jobName = jobName;
        this.salary = salary;
        this.priceUnit = priceUnit;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "LatestDemandInfo{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", salary='" + salary + '\'' +
                ", priceUnit='" + priceUnit + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
