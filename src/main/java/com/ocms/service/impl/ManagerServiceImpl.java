package com.ocms.service.impl;

import com.ocms.dao.ManagerMapper;
import com.ocms.entities.Manager;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.ManagerService;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public ReturnDataAndInfo verifyIsLegal(String loginName, String password) {
        Manager manager = managerMapper.selectByLoginName(loginName);
        if(manager!=null)
            if(MD5Util.verify(password,manager.getPassword()))
                return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"用户名或密码错误");
    }
}
