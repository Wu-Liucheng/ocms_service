package com.ocms.action;

import com.ocms.entities.Resume;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.entities.SignUpInfo;
import com.ocms.entities.UserInfo;
import com.ocms.service.ResumeService;
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

    @Resource
    private ResumeService resumeService;

    @RequestMapping(value = "/sign-up-action",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo signUp(@RequestParam(value = "projectID") Long projectID,
                                    @RequestParam(value = "username") String username){
        Long userId = userInfoService.findByLoginName(username).getId();
        Resume resume = resumeService.getById(userId);
        System.out.println(resume);
        if(resume!=null&&Boolean.TRUE.equals(resume.getIsBeingUsed()))
        {
            return new ReturnDataAndInfo(false,"您已经在被任用中，无法报名！");
        }
        int res = signUpService.newSignUp(new SignUpInfo(userId,projectID,1,null,new Date(),null,null));
        if(res > 0)
            return new ReturnDataAndInfo(true,"");
        else
            return new ReturnDataAndInfo(false,"您已经报名");
    }
}
