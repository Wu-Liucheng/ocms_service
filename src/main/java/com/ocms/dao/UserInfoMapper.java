package com.ocms.dao;

import com.ocms.entities.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    UserInfo selectByLoginName(String loginName);

    UserInfo selectByEmail(String email);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}