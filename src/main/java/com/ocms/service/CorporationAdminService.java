package com.ocms.service;

import com.ocms.entities.ReturnDataAndInfo;

public interface CorporationAdminService {
    ReturnDataAndInfo verifyIsLegal(String loginName, String password);
}
