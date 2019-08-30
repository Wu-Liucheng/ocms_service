package com.ocms.service;

import com.ocms.entities.ReturnDataAndInfo;

public interface CheckerService {
    ReturnDataAndInfo verifyIsLegal(String loginName, String password);

    Long getIdByLoginName(String loginName);
}
