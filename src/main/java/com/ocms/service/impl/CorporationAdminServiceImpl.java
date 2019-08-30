package com.ocms.service.impl;

import com.ocms.dao.CorporationAdminMapper;
import com.ocms.entities.CorporationAdmin;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.CorporationAdminService;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CorporationAdminServiceImpl implements CorporationAdminService {

    @Resource
    private CorporationAdminMapper corporationAdminMapper;

    @Override
    public ReturnDataAndInfo verifyIsLegal(String loginName, String password) {
        CorporationAdmin administrator = corporationAdminMapper.selectByLoginName(loginName);
        if(administrator!=null)
            if(MD5Util.verify(password,administrator.getPassword()))
                return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"用户名或密码错误");
    }
}
