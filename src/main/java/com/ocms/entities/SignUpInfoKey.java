package com.ocms.entities;

public class SignUpInfoKey {
    private Long userId;

    private Long demandId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public SignUpInfoKey(Long userId, Long demandId) {
        this.userId = userId;
        this.demandId = demandId;
    }

    public SignUpInfoKey() {
    }
}