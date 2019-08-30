package com.ocms.action;

import com.ocms.entities.*;
import com.ocms.service.DemandService;
import com.ocms.service.MailService;
import com.ocms.service.UserInfoService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DemandManager {

    @Resource
    private DemandService demandService;

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/latest-demands",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getLatest(){
        List<LatestDemandInfo> demands = demandService.getLatest();
        Map<String,Object> res = new HashMap<>();
        res.put("success",true);
        res.put("demands",demands);
        return res;
    }

    @RequestMapping(value = "/detail-demand-info",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> detailInfo(@RequestParam(value = "projectID") Long projectID,
                                         @RequestParam(value = "username") String username){
        Map<String,Object> res = new HashMap<>();
        UserInfo userInfo = userInfoService.findByLoginName(username);
        DetailDemandInfo detailDemandInfo = demandService.getDetail(userInfo.getId(),projectID);
        res.put("success",true);
        res.put("info",detailDemandInfo);
        return res;
    }

    @RequestMapping(value = "/add-demand",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo addDemand(@RequestBody Demand demand){
        return demandService.addDemand(demand);
    }

    @RequestMapping(value = "/get-demand-apply-by-checker-id",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getDemandApply(@RequestParam(value="id") Long checkerId,
                                             @RequestParam(value="pageCode") Integer pageCode){
        return demandService.getDemandApplyForChecker(checkerId,pageCode);
    }

    @RequestMapping(value = "/get-demand-info-by-id",method = RequestMethod.GET)
    @ResponseBody
    public Demand getById(@RequestParam(value = "id") Long id)
    {
        return demandService.getById(id);
    }

    @RequestMapping(value = "/update-demand-status-by-checker",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo updateByChecker(@RequestBody MessageFromCheckerToManager messageFromCheckerToManager)
    {
        return demandService.updateByChecker(messageFromCheckerToManager);
    }
}
