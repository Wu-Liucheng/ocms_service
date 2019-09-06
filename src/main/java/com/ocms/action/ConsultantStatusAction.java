package com.ocms.action;


import com.ocms.service.UserBindToDemandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class ConsultantStatusAction {

    @Resource
    private UserBindToDemandService userBindToDemandService;

    @RequestMapping(value = "/user-status-for-checker",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getUserStatus(@RequestParam(value = "checkerId") Long checkerId,
                                            @RequestParam(value = "pageCode") Integer pageCode){

        return userBindToDemandService.getUserStatusForChecker(checkerId,pageCode);
    }

}
