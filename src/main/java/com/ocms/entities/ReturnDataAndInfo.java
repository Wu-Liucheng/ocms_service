package com.ocms.entities;

public class ReturnDataAndInfo {
    private Boolean data;
    private String info;

    public ReturnDataAndInfo(Boolean data, String info) {
        this.data = data;
        this.info = info;
    }

    public ReturnDataAndInfo() {
    }

    public Boolean getData() {
        return data;
    }

    public void setData(Boolean data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
