package com.ocms.action;

import com.ocms.entities.UserInfo;
import com.ocms.service.DemandService;
import com.ocms.service.SignUpService;
import com.ocms.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PersonalDemandListManager {
    @Resource
    private DemandService demandService;

    @Resource
    private SignUpService signUpService;

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/personal-lists",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> personalLists(@RequestParam(value = "username") String loginName){
        Map<String,Object> ret = new HashMap<>();
        ret.put("success",true);
        Map<String,Object> data = signUpService.getSignedDemands(userInfoService.findByLoginName(loginName).getId());
        ret.put("data",data);
        return ret;
    }

    @RequestMapping(value = "/personal-lists-page-code",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> personalListsWithPageCode(@RequestParam(value = "username") String loginName,
                                                        @RequestParam(value = "pageCode") Integer pageCode){
        Map<String,Object> ret = new HashMap<>();
        ret.put("success",true);
        Map<String,Object> data = signUpService.getSignedDemands(userInfoService.findByLoginName(loginName).getId(),pageCode);
        ret.put("data",data);
        return ret;
    }
}
