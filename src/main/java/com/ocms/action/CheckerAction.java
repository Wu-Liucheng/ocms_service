package com.ocms.action;

import com.ocms.entities.Checker;
import com.ocms.entities.ReturnDataAndInfo;
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

    @RequestMapping(value = "/check-action",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo checkAction(@RequestParam(value = "isPassed") Boolean isPassed,
                                         @RequestParam(value = "userId") Long userId,
                                         @RequestParam(value = "username") String username,
                                         @RequestParam(value = "demandId") Long demandId,
                                         @RequestParam(value = "objectId") Long objectId,
                                         @RequestParam(value = "checkerId") Long checkerId,
                                         @RequestParam(value = "content") String content){
        return checkerService.checkAction(isPassed, userId, username, demandId, objectId, checkerId, content);
    }
}
