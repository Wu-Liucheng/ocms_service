package com.ocms.service;

import com.ocms.entities.ReturnDataAndInfo;

public interface AdminService {
    ReturnDataAndInfo verifyIsLegal(String loginName,String password);

    ReturnDataAndInfo addRole(String loginName,String password,String email,String mobile,String name,Integer role,Long clientId,String operateName);
}
