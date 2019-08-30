package com.ocms.service.impl;

import com.ocms.dao.SignUpInfoMapper;
import com.ocms.entities.Demand;
import com.ocms.entities.DemandListElement;
import com.ocms.entities.SignUpInfo;
import com.ocms.entities.SignUpInfoKey;
import com.ocms.service.SignUpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SignUpServiceImpl implements SignUpService {

    @Resource
    private SignUpInfoMapper signUpInfoMapper;

    @Override
    public int newSignUp(SignUpInfo signUpInfo) {
        Long userId = signUpInfo.getUserId();
        Long demandId = signUpInfo.getDemandId();
        Object object = signUpInfoMapper.selectByPrimaryKey(new SignUpInfoKey(userId,demandId));
        if(object != null)
            return -1;
        return signUpInfoMapper.insertSelective(signUpInfo);
    }

    @Override
    public Map<String, Object> getSignedDemands(Long userId) {
        Map<String,Object> ret = new HashMap<>();
        List<SignUpInfo> signUpInfos = signUpInfoMapper.selectByUserId(userId);
        List<DemandListElement> demandListElements = new ArrayList<>(4);
        int flag = 0;
        for (SignUpInfo signInfo :
                signUpInfos) {
            DemandListElement demandListElement = new DemandListElement();
            Demand demand = signInfo.getDemand();
            demandListElement.setId(demand.getId());
            demandListElement.setJobName(demand.getName());
            if(demand.getPriceFluctuation()==null||demand.getPriceFluctuation()==0)
                demandListElement.setSalary(demand.getPrice().toString());
            else demandListElement.setSalary((demand.getPrice()-demand.getPriceFluctuation())+"-"+(demand.getPrice()+demand.getPriceFluctuation()));
            demandListElement.setLocation(demand.getWorkAddress());
            demandListElement.setPriceUnit(demand.getPriceUnit());
            demandListElement.setBaozhusu(demand.getIsBoard());
            demandListElement.setDuration(demand.getDuration());
            demandListElement.setCycle(demand.getCycle());
            demandListElement.setReleaseTime(new SimpleDateFormat("yyyy-MM-dd").format(demand.getReleaseTime()));
            if(demand.getProject() == null){
                demandListElement.setProjectName(null);
            }
            else {
                demandListElement.setProjectName(demand.getProject().getName());
            }
            demandListElement.setNumSignUp(signUpInfoMapper.getNumberOfSignUp(demand.getId()));
            demandListElements.add(demandListElement);
            flag ++;
            if(flag == 4)
                break;
        }
        ret.put("lists",demandListElements);
        ret.put("totalPages",(signUpInfos.size()-1)/4+1);
        return ret;
    }

    @Override
    public Map<String, Object> getSignedDemands(Long userId, Integer pageCode) {
        Map<String,Object> ret = new HashMap<>();
        List<SignUpInfo> signUpInfos = signUpInfoMapper.selectByUserId(userId);
        List<DemandListElement> demandListElements = new ArrayList<>(4);
        int flag = 0;
        int totalPages = (signUpInfos.size()-1)/4+1;
        if(pageCode>totalPages)
            pageCode = totalPages;
        for (int i = (pageCode-1)*4; i < pageCode*4; i++) {
            if(i == signUpInfos.size())
                break;
            SignUpInfo signInfo = signUpInfos.get(i);
            DemandListElement demandListElement = new DemandListElement();
            Demand demand = signInfo.getDemand();
            demandListElement.setId(demand.getId());
            demandListElement.setJobName(demand.getName());
            if(demand.getPriceFluctuation()==null||demand.getPriceFluctuation()==0)
                demandListElement.setSalary(demand.getPrice().toString());
            else demandListElement.setSalary((demand.getPrice()-demand.getPriceFluctuation())+"-"+(demand.getPrice()+demand.getPriceFluctuation()));
            demandListElement.setLocation(demand.getWorkAddress());
            demandListElement.setPriceUnit(demand.getPriceUnit());
            demandListElement.setBaozhusu(demand.getIsBoard());
            demandListElement.setDuration(demand.getDuration());
            demandListElement.setCycle(demand.getCycle());
            demandListElement.setReleaseTime(new SimpleDateFormat("yyyy-MM-dd").format(demand.getReleaseTime()));
            if(demand.getProject() == null){
                demandListElement.setProjectName(null);
            }
            else {
                demandListElement.setProjectName(demand.getProject().getName());
            }
            demandListElement.setNumSignUp(signUpInfoMapper.getNumberOfSignUp(demand.getId()));
            demandListElements.add(demandListElement);
            flag ++;
            if(flag == 4)
                break;
        }
        ret.put("lists",demandListElements);
        ret.put("totalPages",totalPages);
        return ret;
    }
}
