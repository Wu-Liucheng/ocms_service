package com.ocms.service.impl;

import com.ocms.dao.CheckerMapper;
import com.ocms.entities.Administrator;
import com.ocms.entities.Checker;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.CheckerService;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CheckerServiceImpl implements CheckerService {

    @Resource
    private CheckerMapper checkerMapper;

    @Override
    public ReturnDataAndInfo verifyIsLegal(String loginName, String password) {
        Checker checker = checkerMapper.selectByLoginName(loginName);
        if(checker!=null)
            if(MD5Util.verify(password,checker.getPassword()))
                return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"用户名或密码错误");
    }

    @Override
    public Long getIdByLoginName(String loginName) {
        Checker checker = checkerMapper.selectByLoginName(loginName);
        if(checker == null)
            return null;
        return checker.getId();
    }
}
