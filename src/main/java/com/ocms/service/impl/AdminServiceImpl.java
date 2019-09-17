package com.ocms.service.impl;

import com.ocms.dao.AdministratorMapper;
import com.ocms.dao.CheckerMapper;
import com.ocms.dao.CorporationAdminMapper;
import com.ocms.dao.ManagerMapper;
import com.ocms.entities.*;
import com.ocms.service.AdminService;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdministratorMapper administratorMapper;

    @Resource
    private ManagerMapper managerMapper;

    @Resource
    private CheckerMapper checkerMapper;

    @Resource
    private CorporationAdminMapper corporationAdminMapper;

    @Override
    public ReturnDataAndInfo verifyIsLegal(String loginName, String password) {
        Administrator administrator = administratorMapper.selectByLoginName(loginName);
        if(administrator!=null)
            if(MD5Util.verify(password,administrator.getPassword()))
                return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"用户名或密码错误");
    }

    @Override
    public ReturnDataAndInfo addRole(String loginName, String password, String email, String mobile, String name, Integer role, Long clientId, String operateName) {
        Administrator administrator = administratorMapper.selectByLoginName(operateName);
        if(administrator == null){
            return new ReturnDataAndInfo(false,"非法操作！");
        }
        Long createId = administrator.getId();
        String safePassword = MD5Util.md5(password);
        if(managerMapper.selectByLoginName(loginName)!=null){
            return new ReturnDataAndInfo(false,"账号已存在！");
        }
        if(managerMapper.selectByEmail(email)!=null){
            return new ReturnDataAndInfo(false,"邮箱已经被注册！");
        }
        if(checkerMapper.selectByLoginName(loginName)!=null){
            return new ReturnDataAndInfo(false,"账号已存在！");
        }
        if(checkerMapper.selectByEmail(email)!=null){
            return new ReturnDataAndInfo(false,"邮箱已被注册！");
        }
        if(corporationAdminMapper.selectByLoginName(loginName)!=null){
            return new ReturnDataAndInfo(false,"账号已存在！");
        }
        if(corporationAdminMapper.selectByEmail(email)!=null){
            return new ReturnDataAndInfo(false,"邮箱已被注册！");
        }
        switch (role){
            case 1:{
                Manager manager = new Manager(null,loginName,safePassword,email,mobile,clientId,name,createId,null,new Date(),null);
                int ret = managerMapper.insertSelective(manager);
                if(ret>0){
                    return new ReturnDataAndInfo(true,"");
                }
                else {
                    return new ReturnDataAndInfo(false,"添加失败！");
                }
            }
            case 2:{
                Checker checker = new Checker(null,loginName,safePassword,email,mobile,clientId,name,createId,null,null,new Date());
                int ret = checkerMapper.insertSelective(checker);
                if(ret>0){
                    return new ReturnDataAndInfo(true,"");
                }
                else {
                    return new ReturnDataAndInfo(false,"添加失败！");
                }
            }
            case 3:{
                CorporationAdmin corporationAdmin = new CorporationAdmin(null,loginName,safePassword,email,mobile,clientId,name,createId,null,null,new Date());
                int ret = corporationAdminMapper.insertSelective(corporationAdmin);
                if(ret>0){
                    return new ReturnDataAndInfo(true,"");
                }
                else {
                    return new ReturnDataAndInfo(false,"添加失败！");
                }
            }
            default:break;
        }
        return new ReturnDataAndInfo(false,"");
    }
}
