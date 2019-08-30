package com.ocms.service;

import com.ocms.entities.ReturnDataAndInfo;

public interface AdminService {
    ReturnDataAndInfo verifyIsLegal(String loginName,String password);
}
