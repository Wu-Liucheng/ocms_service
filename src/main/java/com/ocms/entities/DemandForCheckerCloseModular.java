package com.ocms.entities;

public class DemandForCheckerCloseModular extends DemandForChecker {
    private Boolean isOpened;

    public Boolean getOpened() {
        return isOpened;
    }

    public void setOpened(Boolean opened) {
        isOpened = opened;
    }

    public DemandForCheckerCloseModular(String key, Long id, String name, String number, String status, String modular, String employTime, String workAddress, String startDate, String cycle, Integer price, String priceUnit, Long objectId, Boolean isOpened) {
        super(key, id, name, number, status, modular, employTime, workAddress, startDate, cycle, price, priceUnit, objectId);
        this.isOpened = isOpened;
    }
}
