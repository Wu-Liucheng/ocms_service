package com.ocms.action;

import com.ocms.service.BindUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class BindUserAction {

    @Resource
    private BindUserService bindUserService;


    @RequestMapping(value = "/get-bind-users-for-manager",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getBindInfo(@RequestParam(value = "managerId") Long managerId,
                                          @RequestParam(value = "pageCode") Integer pageCode){
        return bindUserService.getBindUserForManager(managerId,pageCode);
    }
}
