package com.ocms.action;

import com.ocms.entities.CorporationAdmin;
import com.ocms.entities.ProcessNode;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.ProcessNodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class ProcessNodeAction {

    @Resource
    private ProcessNodeService processNodeService;

    @RequestMapping(value = "/get-one-page-process-node",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getOnePageNodeInfo(@RequestParam(value="pageCode") Integer pageCode){
        return processNodeService.getOnePageNodeInfo(pageCode);
    }

    @RequestMapping(value = "/make-process-get-client-by-admin-name",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getClientsInfoByAdminName(@RequestParam(value = "loginName") String loginName)
    {
        return processNodeService.getClientsInfoByAdminName(loginName);
    }

    @RequestMapping(value = "/get-all-checker",method = RequestMethod.GET)
    @ResponseBody
    public List<String> getAllChecker(){
        return processNodeService.getAllChecker();
    }

    @RequestMapping(value = "/add-node",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo addProcessNode(@RequestBody ProcessNode processNode)
    {
        return processNodeService.addProcessNode(processNode);
    }

    @RequestMapping(value = "/verify-client-admin",method = RequestMethod.POST)
    @ResponseBody
    public Boolean verify(@RequestBody CorporationAdmin corporationAdmin){
        return processNodeService.verifyCorporationAdmin(corporationAdmin);
    }

    @RequestMapping(value = "/delete-node",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo delete(@RequestBody ProcessNode node){
        return processNodeService.deleteNode(node);
    }
}
