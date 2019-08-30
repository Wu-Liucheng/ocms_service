package com.ocms.action;

import com.ocms.service.DemandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DemandListManager {

    @Resource
    private DemandService demandService;

    @RequestMapping(value = "/lists-info",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getList(){
        Map<String,Object> ret = new HashMap<>(2);
        ret.put("success",true);
        ret.put("data",demandService.demandListData());
        return ret;
    }

    @RequestMapping(value = "/lists-info-with-conditions",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getWithConditions(@RequestParam(value = "pageCode") Integer pageCode,
                                                @RequestParam(value = "employType") Long employType,
                                                @RequestParam(value = "jobExperience") String jobExperience,
                                                @RequestParam(value = "demandDuration") Integer demandDuration,
                                                @RequestParam(value = "salary") Integer salary){
        System.out.println(pageCode+" "+employType+" "+jobExperience+" "+demandDuration+" "+salary);
        Map<String,Object> ret = new HashMap<>(2);
        ret.put("success",true);
        ret.put("data",demandService.demandListDataWithConditions(pageCode,employType,jobExperience,demandDuration,salary));
        return ret;
    }
}
