package com.ocms.service;

import com.ocms.entities.ReturnDataAndInfo;

public interface ManagerService {
    ReturnDataAndInfo verifyIsLegal(String loginName, String password);

    Long getIdByUsername(String username);
}
