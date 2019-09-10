package com.ocms.entities;

import java.sql.Timestamp;
import java.util.Date;

public class CommentOnUser {
    private Long id;

    private Long managerId;

    private Long userId;

    private String comment;

    private Date createDate;

    private Long clientId;

    private Manager manager;

    private Client client;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public CommentOnUser(Long id, Long managerId, Long userId, String comment, Date createDate, Long clientId, Manager manager, Client client) {
        this.id = id;
        this.managerId = managerId;
        this.userId = userId;
        this.comment = comment;
        this.createDate = createDate;
        this.clientId = clientId;
        this.manager = manager;
        this.client = client;
    }

    public CommentOnUser(Long id, Long managerId, Long userId, String comment, Date createDate, Long clientId) {
        this.id = id;
        this.managerId = managerId;
        this.userId = userId;
        this.comment = comment;
        this.createDate = createDate;
        this.clientId = clientId;
    }

    public CommentOnUser(Long id, Long managerId, Long userId, String comment, Timestamp createDate, Long clientId) {
        this.id = id;
        this.managerId = managerId;
        this.userId = userId;
        this.comment = comment;
        this.createDate = createDate;
        this.clientId = clientId;
    }

    public CommentOnUser(Long managerId, Long userId, String comment) {
        this.managerId = managerId;
        this.userId = userId;
        this.comment = comment;
    }

    public CommentOnUser() {
    }
}