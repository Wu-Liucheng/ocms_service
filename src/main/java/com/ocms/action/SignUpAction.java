package com.ocms.action;

import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.entities.SignUpInfo;
import com.ocms.entities.UserInfo;
import com.ocms.service.SignUpService;
import com.ocms.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class SignUpAction {
    @Resource
    private SignUpService signUpService;

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/sign-up-action",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo signUp(@RequestParam(value = "projectID") Long projectID,
                                    @RequestParam(value = "username") String username){
        Long userId = userInfoService.findByLoginName(username).getId();
        int res = signUpService.newSignUp(new SignUpInfo(userId,projectID,1,null,new Date(),null,null));
        if(res > 0)
            return new ReturnDataAndInfo(true,"");
        else
            return new ReturnDataAndInfo(false,"您已经报名");
    }
}
