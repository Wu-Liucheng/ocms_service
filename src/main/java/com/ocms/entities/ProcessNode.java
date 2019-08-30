package com.ocms.entities;

import java.util.Date;

public class ProcessNode {
    private Long id;

    private Long clientId;

    private Long checkerId;

    private Date createDate;

    private Long createBy;

    private Client client;

    private Checker checker;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(Long checkerId) {
        this.checkerId = checkerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}