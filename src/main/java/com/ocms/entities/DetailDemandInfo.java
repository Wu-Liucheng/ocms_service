package com.ocms.entities;

public class DetailDemandInfo {
    private Long id;
    private String jobName;
    private String salary;
    private String priceUnit;
    private String location;
    private String duration;
    private String cycle;
    private Boolean isBaozhusu;
    private Boolean isSignUp;
    private Integer numSignUp;
    private String releaseTime;
    private String company;
    private String projectName;
    private String description;
    private String companyIntro;

    public DetailDemandInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Boolean getBaozhusu() {
        return isBaozhusu;
    }

    public void setBaozhusu(Boolean baozhusu) {
        isBaozhusu = baozhusu;
    }

    public Boolean getSignUp() {
        return isSignUp;
    }

    public void setSignUp(Boolean signUp) {
        isSignUp = signUp;
    }

    public Integer getNumSignUp() {
        return numSignUp;
    }

    public void setNumSignUp(Integer numSignUp) {
        this.numSignUp = numSignUp;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    public DetailDemandInfo(Long id, String jobName, String salary, String priceUnit, String location, String duration, String cycle, Boolean isBaozhusu, Boolean isSignUp, Integer numSignUp, String releaseTime, String company, String projectName, String description, String companyIntro) {
        this.id = id;
        this.jobName = jobName;
        this.salary = salary;
        this.priceUnit = priceUnit;
        this.location = location;
        this.duration = duration;
        this.cycle = cycle;
        this.isBaozhusu = isBaozhusu;
        this.isSignUp = isSignUp;
        this.numSignUp = numSignUp;
        this.releaseTime = releaseTime;
        this.company = company;
        this.projectName = projectName;
        this.description = description;
        this.companyIntro = companyIntro;
    }

    @Override
    public String toString() {
        return "DetailDemandInfo{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", salary='" + salary + '\'' +
                ", priceUnit='" + priceUnit + '\'' +
                ", location='" + location + '\'' +
                ", duration='" + duration + '\'' +
                ", cycle='" + cycle + '\'' +
                ", isBaozhusu=" + isBaozhusu +
                ", isSignUp=" + isSignUp +
                ", numSignUp=" + numSignUp +
                ", releaseTime='" + releaseTime + '\'' +
                ", company='" + company + '\'' +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", companyIntro='" + companyIntro + '\'' +
                '}';
    }
}
