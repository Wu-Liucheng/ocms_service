package com.ocms.service.impl;

import com.ocms.dao.UserBindToDemandMapper;
import com.ocms.entities.UserBindToDemand;
import com.ocms.entities.UserBindToDemandForChecker;
import com.ocms.service.UserBindToDemandService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBindToDemandServiceImpl implements UserBindToDemandService {

    @Resource
    private UserBindToDemandMapper userBindToDemandMapper;

    @Override
    public Map<String, Object> getUserStatusForChecker(Long checkerId, Integer pageCode) {
        int total = userBindToDemandMapper.countOfOneChecker(checkerId);
        int pageSize = 6;
        int totalPage = (total-1)/6+1;
        if(pageCode < 1){
            pageCode = 1;
        }
        if(pageCode > totalPage){
            pageCode = totalPage;
        }
        Map<String,Object> param = new HashMap<>(2);
        param.put("checkerId",checkerId);
        param.put("start",(pageCode-1)*pageSize);
        List<UserBindToDemand> userBindToDemands = userBindToDemandMapper.selectForOneChecker(param);
        List<UserBindToDemandForChecker> data = new ArrayList<>(6);
        userBindToDemands.forEach((UserBindToDemand u)->{
            UserBindToDemandForChecker d = new UserBindToDemandForChecker(null,null,
                    u.getUserId(),u.getDemandId(),u.getResume()==null?null:u.getResume().getName(),
                    u.getDemand()==null?null:u.getDemand().getName());
            data.add(d);
        });
        for(int i = 0; i < data.size(); i++){
            data.get(i).setKey(i+1+"");
            data.get(i).setNumber(i+1+"");
        }
        Map<String,Object> ret = new HashMap<>();
        ret.put("success",true);
        ret.put("data",data);
        ret.put("total",total);
        return ret;
    }
}
