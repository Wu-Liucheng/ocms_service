package com.ocms.entities;

public class Administrator {
    private Long id;

    private String loginName;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Administrator() {
    }

    public Administrator(Long id, String loginName, String password) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
    }
}