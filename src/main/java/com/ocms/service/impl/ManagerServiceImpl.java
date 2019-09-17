package com.ocms.service.impl;

import com.ocms.dao.ClientMapper;
import com.ocms.dao.ManagerMapper;
import com.ocms.entities.Client;
import com.ocms.entities.Manager;
import com.ocms.entities.ManagerToFront;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.ManagerService;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;

    @Resource
    private ClientMapper clientMapper;

    @Override
    public ReturnDataAndInfo verifyIsLegal(String loginName, String password) {
        Manager manager = managerMapper.selectByLoginName(loginName);
        if(manager!=null)
            if(MD5Util.verify(password,manager.getPassword()))
                return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"用户名或密码错误");
    }

    @Override
    public Long getIdByUsername(String username) {
        Manager manager = managerMapper.selectByLoginName(username);
        if(manager == null)
            return null;
        else
            return manager.getId();
    }

    @Override
    public Map<String, Object> getOnePage(Integer pageCode) {
        Map<String,Object> ret = new HashMap<>();
        int total = managerMapper.count();
        int totalPage = (total-1)/6+1;
        if(pageCode<1) pageCode = 1;
        if(pageCode>totalPage) pageCode = totalPage;
        List<Manager> managers = managerMapper.selectOnePage((pageCode-1)*6);
        List<ManagerToFront> data = new ArrayList<>(6);
        managers.forEach(manager->{
            Client client = clientMapper.selectByPrimaryKey(manager.getClientId());
            ManagerToFront d = new ManagerToFront(
                    null,null,manager.getId(),manager.getLoginName(),manager.getName(),
                    manager.getEmail(),manager.getMobile(),manager.getClientId(),client==null?null:client.getCorporateName()
            );
            data.add(d);
        });
        for(int i = 0; i < data.size(); i++){
            ManagerToFront d = data.get(i);
            d.setKey(i+1+"");
            d.setNumber(i+1+"");
        }
        ret.put("success",true);
        ret.put("data",data);
        ret.put("total",total);
        return ret;
    }

    @Override
    public ReturnDataAndInfo deleteRole(Long id) {
        int ret = managerMapper.deleteByPrimaryKey(id);
        if(ret>0){
            return new ReturnDataAndInfo(true,"");
        }
        else {
            return new ReturnDataAndInfo(false,"系统错误，删除失败！");
        }
    }
}
