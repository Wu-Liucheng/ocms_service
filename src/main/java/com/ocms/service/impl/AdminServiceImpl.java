package com.ocms.service.impl;

import com.ocms.dao.AdministratorMapper;
import com.ocms.entities.Administrator;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.AdminService;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdministratorMapper administratorMapper;

    @Override
    public ReturnDataAndInfo verifyIsLegal(String loginName, String password) {
        Administrator administrator = administratorMapper.selectByLoginName(loginName);
        if(administrator!=null)
            if(MD5Util.verify(password,administrator.getPassword()))
                return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"用户名或密码错误");
    }
}
