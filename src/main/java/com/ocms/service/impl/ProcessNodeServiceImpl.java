package com.ocms.service.impl;

import com.ocms.dao.CheckerMapper;
import com.ocms.dao.ClientMapper;
import com.ocms.dao.CorporationAdminMapper;
import com.ocms.dao.ProcessNodeMapper;
import com.ocms.entities.*;
import com.ocms.service.ProcessNodeService;
import com.ocms.util.EntityToHashMapUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ProcessNodeServiceImpl implements ProcessNodeService {

    @Resource
    private ProcessNodeMapper processNodeMapper;

    @Resource
    private CorporationAdminMapper corporationAdminMapper;

    @Resource
    private ClientMapper clientMapper;

    @Resource
    private CheckerMapper checkerMapper;

    @Override
    public Map<String, Object> getOnePageNodeInfo(Integer pageCode) {
        int total = processNodeMapper.count();
        int pageSize = 6;
        int totalPage = (total-1)/6+1;
        if(pageCode<1)
        {
            pageCode = 1;
        }
        if(pageCode>totalPage)
        {
            pageCode = totalPage;
        }
        List<ProcessNode> processNodes = processNodeMapper.selectOnePage((pageCode-1)*pageSize);
        List<ProcessNodeInfoReturnToFront> info = new ArrayList<>();
        processNodes.forEach((ProcessNode processNode)->{
            ProcessNodeInfoReturnToFront projectInfoReturnToFront = new ProcessNodeInfoReturnToFront(
                    processNode.getId().toString(),processNode.getId(),processNode.getClientId(),
                    processNode.getCheckerId(),processNode.getClient()==null?null:processNode.getClient().getCorporateName(),
                    processNode.getChecker()==null?null:processNode.getChecker().getName()
            );
            info.add(projectInfoReturnToFront);
        });
        Map<String,Object> ret = new HashMap<>();
        ret.put("success",true);
        ret.put("info",info);
        ret.put("total",total);
        return ret;
    }

    @Override
    public List<String> getClientsInfoByAdminName(String loginName) {
        CorporationAdmin corporationAdmin = corporationAdminMapper.selectByLoginName(loginName);
        List<String> ret = new ArrayList<>();
        if(corporationAdmin != null)
        {
            Client client = clientMapper.selectByPrimaryKey(corporationAdmin.getClientId());
            if(client!=null){
                ret.add(client.getId()+":"+client.getCorporateName());
            }
        }
        return ret;
    }

    @Override
    public List<String> getAllChecker() {

        List<Checker> checkers = checkerMapper.selectAll();
        List<String> ret = new ArrayList<>();
        checkers.forEach((Checker checker)->{
            ret.add(checker.getId()+":"+checker.getName());
        });
        return ret;
    }

    @Override
    public ReturnDataAndInfo addProcessNode(ProcessNode processNode) {
        processNode.setCreateDate(new Date());
        List<ProcessNode> processNodes = processNodeMapper.selectSelective(processNode);
        if(processNodes.size() > 0){
            return new ReturnDataAndInfo(false,"结点已存在！！！");
        }
        int ret = processNodeMapper.insertSelective(processNode);
        if(ret>0)
            return new ReturnDataAndInfo(true,"");
        return new ReturnDataAndInfo(false,"添加失败！");
    }

    @Override
    public Boolean verifyCorporationAdmin(CorporationAdmin corporationAdmin) {
        Map<String,Object> map = new HashMap<>();
        map.put("loginName",corporationAdmin.getLoginName());
        map.put("clientId",corporationAdmin.getClientId());
        CorporationAdmin corporationAdmin1 = corporationAdminMapper.selectByLoginNameAndClientId(map);
        if(corporationAdmin1 == null)
            return false;
        return true;
    }

    @Override
    public ReturnDataAndInfo deleteNode(ProcessNode node) {
        int ret = processNodeMapper.deleteSelective(node);
        if(ret > 0){
            return new ReturnDataAndInfo(true,"");
        }
        else {
            return new ReturnDataAndInfo(false,"删除失败！");
        }
    }
}
