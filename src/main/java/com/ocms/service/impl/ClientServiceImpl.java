package com.ocms.service.impl;

import com.ocms.dao.ClientMapper;
import com.ocms.dao.CorporationAdminMapper;
import com.ocms.entities.Client;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.entities.SimplyClient;
import com.ocms.service.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    private ClientMapper clientMapper;

    @Resource
    private CorporationAdminMapper corporationAdminMapper;

    @Override
    public Client getOneClientInfo(Long id) {
        return clientMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> getOnePageClientInfo(Integer pageCode) {
        List<Client> clients = clientMapper.selectAll();
        Integer total = clients.size();
        if(pageCode>(total-1)/6+1)
            pageCode = (total-1)/6+1;
        List<SimplyClient> ret = new ArrayList<>(6);
        for(int i = (pageCode-1)*6; i < pageCode*6; i++)
        {
            if(i == clients.size())
                break;
            Client client = clients.get(i);
            ret.add(new SimplyClient(String.valueOf(i),client.getId(),client.getCustomerNumber(),client.getCorporateName(),client.getContacts()
            ,client.getContactsTel(),client.getContactsEmail()));
        }
        Map<String,Object> res = new HashMap<>(3);
        res.put("clients",ret);
        res.put("total",total);
        res.put("success",true);
        return res;
    }

    @Override
    public Boolean verifyCorporateAdmin(Map map) {
        if(corporationAdminMapper.selectByLoginNameAndClientId(map)==null)
            return false;
        return true;
    }

    @Override
    public ReturnDataAndInfo save(Client client) {
        String customerNumber = client.getCustomerNumber();
        Client c = clientMapper.selectByCustomerNumber(customerNumber);
        if(c!=null&&!c.getId().equals(client.getId()))
            return new ReturnDataAndInfo(false,"客户编号冲突！");
        else {
            int r = clientMapper.updateByPrimaryKey(client);
            if(r>0)
                return new ReturnDataAndInfo(true,"");
            else
                return new ReturnDataAndInfo(false,"更新出错");
        }
    }

    @Override
    public ReturnDataAndInfo add(Client client) {
        String customerNumber = client.getCustomerNumber();
        Client c = clientMapper.selectByCustomerNumber(customerNumber);
        if(c!=null)
            return new ReturnDataAndInfo(false,"客户编号冲突！");
        else {
            client.setCreateDate(new Date());
            int r = clientMapper.insertSelective(client);
            if(r>0)
                return new ReturnDataAndInfo(true,"");
            else
                return new ReturnDataAndInfo(false,"添加出错！");
        }
    }
}
