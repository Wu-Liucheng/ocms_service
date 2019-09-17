package com.ocms.service.impl;

import com.ocms.dao.ClientMapper;
import com.ocms.dao.CorporationAdminMapper;
import com.ocms.entities.Client;
import com.ocms.entities.CorpAdminToFront;
import com.ocms.entities.CorporationAdmin;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.CorporationAdminService;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CorporationAdminServiceImpl implements CorporationAdminService {

    @Resource
    private CorporationAdminMapper corporationAdminMapper;

    @Resource
    private ClientMapper clientMapper;

    @Override
    public ReturnDataAndInfo verifyIsLegal(String loginName, String password) {
        CorporationAdmin administrator = corporationAdminMapper.selectByLoginName(loginName);
        if(administrator!=null)
            if(MD5Util.verify(password,administrator.getPassword()))
                return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"用户名或密码错误");
    }

    @Override
    public Map<String, Object> getOnePage(Integer pageCode) {
        Map<String,Object> ret = new HashMap<>();
        int total = corporationAdminMapper.count();
        int totalPage = (total-1)/6+1;
        if(pageCode<1) pageCode=1;
        if(pageCode>totalPage) pageCode=totalPage;
        List<CorporationAdmin> admins = corporationAdminMapper.selectOnePage((pageCode-1)*6);
        List<CorpAdminToFront> data = new ArrayList<>(6);
        admins.forEach(admin -> {
            Client client = clientMapper.selectByPrimaryKey(admin.getClientId());
            CorpAdminToFront d = new CorpAdminToFront(
                    null,null,admin.getId(),admin.getLoginName(),
                    admin.getName(),admin.getEmail(),admin.getMobile(),admin.getClientId(),
                    client==null?null:client.getCorporateName()
            );
            data.add(d);
        });
        for(int i = 0; i < data.size(); i++){
            CorpAdminToFront d = data.get(i);
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
        int ret = corporationAdminMapper.deleteByPrimaryKey(id);
        if(ret>0){
            return new ReturnDataAndInfo(true,"");
        }
        else {
            return new ReturnDataAndInfo(false,"系统错误，删除失败！");
        }
    }
}
