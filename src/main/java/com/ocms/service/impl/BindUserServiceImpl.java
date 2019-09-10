package com.ocms.service.impl;

import com.ocms.dao.UserBindToDemandMapper;
import com.ocms.entities.UserBindInfoForManager;
import com.ocms.entities.UserBindToDemand;
import com.ocms.service.BindUserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BindUserServiceImpl implements BindUserService {

    @Resource
    private UserBindToDemandMapper userBindToDemandMapper;

    @Override
    public Map<String, Object> getBindUserForManager(Long managerId, Integer pageCode) {
        List<UserBindToDemand> userBindToDemands = userBindToDemandMapper.selectForOneManager(managerId);
        int total = userBindToDemands.size();
        int totalPages = (total-1)/6+1;
        if(pageCode > totalPages)
        {
            pageCode = totalPages;
        }
        if(pageCode < 1){
            pageCode = 1;
        }
        List<UserBindInfoForManager> data = new ArrayList<>(6);
        for(int i = (pageCode - 1) * 6; i < pageCode * 6; i++){
            if(i == total)
                break;
            UserBindToDemand userBindToDemand = userBindToDemands.get(i);
            UserBindInfoForManager d = new UserBindInfoForManager(
                    i+1+"",i+1+"",userBindToDemand.getUserId(),userBindToDemand.getResume().getName()
            );
            data.add(d);
        }
        Map<String,Object> ret = new HashMap<>();
        ret.put("success",true);
        ret.put("data",data);
        ret.put("total",total);
        return ret;
    }
}
