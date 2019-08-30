package com.ocms.service;

import com.ocms.entities.UserInfo;

public interface UserInfoService {
    UserInfo findByLoginName(String loginName);

    UserInfo findByEmail(String email);

    int addUser(UserInfo userInfo);

    int changePassword(Long id,String password);
}
