package com.ocms.service;

import com.ocms.entities.ReturnDataAndInfo;

import java.util.Map;

public interface CorporationAdminService {
    ReturnDataAndInfo verifyIsLegal(String loginName, String password);

    Map<String,Object> getOnePage(Integer pageCode);
}
