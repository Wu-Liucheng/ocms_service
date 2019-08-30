package com.ocms.service.impl;

import com.ocms.dao.UserInfoMapper;
import com.ocms.entities.UserInfo;
import com.ocms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;


    @Override
    public UserInfo findByLoginName(String loginName) {
        return userInfoMapper.selectByLoginName(loginName);
    }

    @Override
    public UserInfo findByEmail(String email) {
        return userInfoMapper.selectByEmail(email);
    }

    @Override
    public int addUser(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public int changePassword(Long id, String password) {
        return userInfoMapper.updateByPrimaryKeySelective(new UserInfo(id, password));
    }
}
