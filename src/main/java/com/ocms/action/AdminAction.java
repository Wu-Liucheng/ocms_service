package com.ocms.action;

import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class AdminAction {

    @Resource
    private ResumeService resumeService;

    @Resource
    private AdminService adminService;

    @Resource
    private CheckerService checkerService;

    @Resource
    private ManagerService managerService;

    @Resource
    private CorporationAdminService corporationAdminService;

    @RequestMapping(value = "/admin-login",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo loginVerify(@RequestParam(value = "username") String username,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "role") Integer role){
        if(role==0)
            return adminService.verifyIsLegal(username,password);
        else if(role==1)
            return managerService.verifyIsLegal(username,password);
        else if (role==2)
            return checkerService.verifyIsLegal(username,password);
        else if(role==3)
            return corporationAdminService.verifyIsLegal(username,password);
        return new ReturnDataAndInfo(false,"");
    }

    @RequestMapping(value = "/get-one-page-consultants",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getConsultants(@RequestParam(value = "pageCode") Integer pageCode){
        return resumeService.getOnePageConsultantInfo(pageCode);
    }

    @RequestMapping(value = "/get-manager-id",method = RequestMethod.POST)
    @ResponseBody
    public Long getManagerId(@RequestParam(value = "username") String username){
        return managerService.getIdByUsername(username);
    }
}
