package com.ocms.service;

import com.ocms.entities.ReturnDataAndInfo;

import java.util.Map;

public interface ManagerService {
    ReturnDataAndInfo verifyIsLegal(String loginName, String password);

    Long getIdByUsername(String username);

    Map<String,Object> getOnePage(Integer pageCode);

    ReturnDataAndInfo deleteRole(Long id);
}
