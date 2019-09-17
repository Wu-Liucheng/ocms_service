package com.ocms.action;

import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.service.*;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
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

    @RequestMapping(value = "/get-manager-data",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getManagerData(@RequestParam(value = "pageCode") Integer pageCode,
                                             @RequestParam(value = "key") String key,
                                             @RequestParam(value = "value") String value){
        boolean success = MD5Util.verify(key,value);
        if(!success){
            Map<String,Object> ret = new HashMap<>(1);
            ret.put("success",false);
            return ret;
        }
        return managerService.getOnePage(pageCode);
    }

    @RequestMapping(value = "/get-checker-data",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCheckerData(@RequestParam(value = "pageCode") Integer pageCode,
                                             @RequestParam(value = "key") String key,
                                             @RequestParam(value = "value") String value){
        boolean success = MD5Util.verify(key,value);
        if(!success){
            Map<String,Object> ret = new HashMap<>(1);
            ret.put("success",false);
            return ret;
        }
        return checkerService.getOnePage(pageCode);
    }

    @RequestMapping(value = "/get-corporate-admin-data",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCorporateAdminData(@RequestParam(value = "pageCode") Integer pageCode,
                                             @RequestParam(value = "key") String key,
                                             @RequestParam(value = "value") String value){
        boolean success = MD5Util.verify(key,value);
        if(!success){
            Map<String,Object> ret = new HashMap<>(1);
            ret.put("success",false);
            return ret;
        }
        return corporationAdminService.getOnePage(pageCode);
    }

    @RequestMapping(value = "/delete-manager",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo deleteManager(@RequestParam(value = "id") Long id,
                                           @RequestParam(value = "key") String key,
                                           @RequestParam(value = "value") String value){
        boolean success = MD5Util.verify(key,value);
        if(!success){
            return new ReturnDataAndInfo(false,"非法操作！");
        }
        return managerService.deleteRole(id);
    }
    @RequestMapping(value = "/delete-checker",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo deleteChecker(@RequestParam(value = "id") Long id,
                                           @RequestParam(value = "key") String key,
                                           @RequestParam(value = "value") String value){
        boolean success = MD5Util.verify(key,value);
        if(!success){
            return new ReturnDataAndInfo(false,"非法操作！");
        }
        return checkerService.deleteRole(id);
    }
    @RequestMapping(value = "/delete-corporate-admin",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo deleteCorporateAdmin(@RequestParam(value = "id") Long id,
                                           @RequestParam(value = "key") String key,
                                           @RequestParam(value = "value") String value){
        boolean success = MD5Util.verify(key,value);
        if(!success){
            return new ReturnDataAndInfo(false,"非法操作！");
        }
        return corporationAdminService.deleteRole(id);
    }

    @RequestMapping(value = "/add-admin",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo addAdmin(@RequestParam(value = "key") String key,
                                      @RequestParam(value = "value") String value,
                                      @RequestParam(value = "loginName") String loginName,
                                      @RequestParam(value = "password") String password,
                                      @RequestParam(value = "email") String email,
                                      @RequestParam(value = "phone") String mobile,
                                      @RequestParam(value = "name") String name,
                                      @RequestParam(value = "role") Integer role,
                                      @RequestParam(value = "clientId") Long clientId,
                                      @RequestParam(value = "operateName") String operateName){
        boolean legal = MD5Util.verify(key,value);
        if(!legal){
            return new ReturnDataAndInfo(false,"非法操作！");
        }
        return adminService.addRole(loginName, password, email, mobile, name, role, clientId, operateName);
    }
}
