package com.ocms.action;

import com.ocms.entities.Client;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ClientAction {

    @Resource
    private ClientService clientService;

    @RequestMapping(value="/get-one-page-clients",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getOnePageClientInfo(@RequestParam("pageCode") Integer pageCode)
    {
        return clientService.getOnePageClientInfo(pageCode);
    }

    @RequestMapping(value = "/get-one-client",method = RequestMethod.GET)
    @ResponseBody
    public Client getOneInfo(@RequestParam("id") Long id){
        return clientService.getOneClientInfo(id);
    }

    @RequestMapping(value = "/verify-corporate-admin",method = RequestMethod.POST)
    @ResponseBody
    public Boolean isLegal(@RequestParam("loginName") String loginName,
                           @RequestParam("clientId") Long clientId){
        Map<String,Object> map = new HashMap<>(2);
        map.put("loginName",loginName);map.put("clientId",clientId);
        return clientService.verifyCorporateAdmin(map);
    }

    @RequestMapping(value = "/save-one-client",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo save(@RequestBody Client client){
        //System.out.println(params);

        return clientService.save(client);
    }

    @RequestMapping(value = "/add-client",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo add(@RequestBody Client client){
        return clientService.add(client);
    }
}
