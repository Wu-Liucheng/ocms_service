package com.ocms.entities;

import java.util.Objects;

public class ProcessNodeInfoReturnToFront {
    private String key;
    private Long id;
    private Long clientId;
    private Long checkerId;
    private String clientName;
    private String checkerName;

    public ProcessNodeInfoReturnToFront(String key, Long id, Long clientId, Long checkerId, String clientName, String checkerName) {
        this.key = key;
        this.id = id;
        this.clientId = clientId;
        this.checkerId = checkerId;
        this.clientName = clientName;
        this.checkerName = checkerName;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    @Override
    public String toString() {
        return "ProcessNodeInfoReturnToFront{" +
                "key='" + key + '\'' +
                ", id=" + id +
                ", clientId=" + clientId +
                ", checkerId=" + checkerId +
                ", clientName='" + clientName + '\'' +
                ", checkerName='" + checkerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessNodeInfoReturnToFront that = (ProcessNodeInfoReturnToFront) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(id, that.id) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(checkerId, that.checkerId) &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(checkerName, that.checkerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, id, clientId, checkerId, clientName, checkerName);
    }
}
