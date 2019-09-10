package com.ocms.action;


import com.ocms.entities.Resume;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.entities.UserBindToDemand;
import com.ocms.service.UserBindToDemandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/consultant-status",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> consultantStatus(@RequestParam(value = "id") Long resumeId){
        return userBindToDemandService.getStatus(resumeId);
    }

    @RequestMapping(value = "/update-consultant-status",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo updateStatus(@RequestBody Resume resume){
        return userBindToDemandService.updateConsultantStatus(resume);
    }

    @RequestMapping(value = "/relation-is-over",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo over(@RequestBody UserBindToDemand userBindToDemand){
        return userBindToDemandService.relationIsOver(userBindToDemand);
    }

}
