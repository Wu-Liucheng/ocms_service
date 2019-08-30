package com.ocms.action;

import com.ocms.entities.Checker;
import com.ocms.service.CheckerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CheckerAction {

    @Resource
    CheckerService checkerService;

    @RequestMapping(value = "/get-checker-id",method = RequestMethod.GET)
    @ResponseBody
    public Long getCheckerId(@RequestParam(value = "loginName") String loginName){
        return checkerService.getIdByLoginName(loginName);
    }
}
