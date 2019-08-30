package com.ocms.action;


                                            /***
                                             *      ┌─┐       ┌─┐
                                             *   ┌──┘ ┴───────┘ ┴──┐
                                             *   │                 │
                                             *   │       ───       │
                                             *   │  ─┬┘       └┬─  │
                                             *   │                 │
                                             *   │       ─┴─       │
                                             *   │                 │
                                             *   └───┐         ┌───┘
                                             *       │         │
                                             *       │         │
                                             *       │         │
                                             *       │         └──────────────┐
                                             *       │                        │
                                             *       │                        ├─┐
                                             *       │                        ┌─┘
                                             *       │                        │
                                             *       └─┐  ┐  ┌───────┬──┐  ┌──┘
                                             *         │ ─┤ ─┤       │ ─┤ ─┤
                                             *         └──┴──┘       └──┴──┘
                                             *                神兽保佑
                                             *               代码无BUG!
                                             */
import com.ocms.entities.Resume;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.entities.UserInfo;
import com.ocms.service.ResumeService;
import com.ocms.service.UserInfoService;
import com.ocms.util.EntityToHashMapUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ResumeManager {

    @Resource
    ResumeService resumeService;

    @Resource
    UserInfoService userInfoService;

    @RequestMapping(value = "/get-self-info",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getInfo(@RequestParam("username") String username){
        UserInfo userInfo = userInfoService.findByLoginName(username);
        Long id = userInfo.getId();
        Resume resume = resumeService.getById(id);


        if(resume.getBirth()==null)
            resume.setBirth(new Date());
        if(resume.getPlanDate()==null)
            resume.setPlanDate(new Date());
        if(resume.getCommunicateDate()==null)
            resume.setCommunicateDate(new Date());
        if(resume.getDegree()==null)
            resume.setDegree("");
        if(resume.getPriceUnit() == null)
            resume.setPriceUnit("元/天");

        Map selfInfo = EntityToHashMapUtil.transfer(resume);
        selfInfo.put("phone",resume.getMobile());
        selfInfo.put("isBaseInfoPage",true);
        selfInfo.put("username",userInfo.getLoginName());
        selfInfo.replace("email",userInfo.getEmail());
        HashMap<String,Object> data = new HashMap<>();
        data.put("selfInfo",selfInfo);
        HashMap<String,Object> res = new HashMap<>();
        res.put("success",true);
        res.put("data",data);
        System.out.println(username);
        return res;
    }

    @RequestMapping(value = "/admin-get-resume",method =RequestMethod.GET)
    @ResponseBody
    public Resume infoForAdmin(@RequestParam(value = "id") Long id)
    {
        Resume ret = resumeService.getById(id);
        ret.setPriceUnit(null);ret.setBirth(null);ret.setDegree(null);ret.setIdealSalary(null);
        ret.setIsBeingUsed(null);ret.setCreateDate(null);ret.setCreatedBy(null);ret.setSchool(null);
        ret.setIdNumber(null);
        return ret;
    }

    @RequestMapping(value = "/admin-delete-user",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo deleteInfo(@RequestParam(value = "id") Long id)
    {
        int res = resumeService.deleteConsultantInfo(id);
        if(res>0)
            return new ReturnDataAndInfo(true,"");
        else
            return new ReturnDataAndInfo(false,"failure");
    }

    @RequestMapping(value = "/save-self-info",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo saveInfo(@RequestParam("loginName") String loginName,
                                      @RequestParam("name") String name,
                                      @RequestParam("email") String email,
                                      @RequestParam("qq") String qq,
                                      @RequestParam("phone") String phone,
                                      @RequestParam("estimateLevel") String estimateLevel,
                                      @RequestParam("goodAt") String goodAt,
                                      @RequestParam("employYears") String employYears,
                                      @RequestParam("planDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date planDate,
                                      @RequestParam("communicateDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date communicateDate,
                                      @RequestParam(value = "isBeingUsed") String is_being_used,
                                      @RequestParam("communicatePerson") String communicatePerson,
                                      @RequestParam("employNumber") String employNumber,
                                      @RequestParam("idealSalary") String ideal_salary,
                                      @RequestParam("idNumber") String idNumber,
                                      @RequestParam("birth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birth,
                                      @RequestParam("degree") String degree,
                                      @RequestParam("priceUnit") String priceUnit,
                                      @RequestParam("school") String school,
                                      @RequestParam(value = "sex") String s,
                                      @RequestParam("location") String location,
                                      @RequestParam("otherInfo") String otherInfo
                                      ){
        UserInfo userInfo = userInfoService.findByLoginName(loginName);
        Boolean isBeingUsed = false;
        Boolean sex = true;
        Integer idealSalary = 0;
        if(is_being_used==null||is_being_used.equals("false"))
            isBeingUsed = false;
        else isBeingUsed = true;
        if(s==null||s.equals("false"))
            sex = false;
        else sex = true;
        if(ideal_salary==null)
            idealSalary = 0;
        else try {
            idealSalary = Integer.parseInt(ideal_salary);
        }catch (Exception e){
            e.printStackTrace();
            idealSalary = 0;
        }

        Resume resume = new Resume(userInfo.getId(),phone,idNumber,name,email,qq,employYears,goodAt,estimateLevel,planDate,
                communicateDate,isBeingUsed,communicatePerson,employNumber,idealSalary,birth,degree,priceUnit,
                school,sex,location,otherInfo,null,null,null,null);
        int ret = resumeService.saveResume(resume);
        if(ret > 0)
            return new ReturnDataAndInfo(true,"");
        else
            return new ReturnDataAndInfo(false,"");
    }

    @RequestMapping(value = "/admin-save-resume",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo adminSaveInfo(@RequestParam("id") Long id,
                                           @RequestParam("name") String name,
                                           @RequestParam("email") String email,
                                           @RequestParam("mobile") String mobile,
                                           @RequestParam("estimateLevel") String estimateLevel,
                                           @RequestParam("employYears") String employYears,
                                           @RequestParam("planDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date planDate,
                                           @RequestParam("communicateDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date communicateDate,
                                           @RequestParam("communicatePerson") String communicatePerson,
                                           @RequestParam("employNumber") String employNumber,
                                           @RequestParam("location") String location,
                                           @RequestParam("otherInfo") String otherInfo){
        Resume resume = new Resume(id,mobile,name,email,employYears,estimateLevel,planDate,communicateDate,communicatePerson,employNumber,location,otherInfo);
        int ret = resumeService.saveResume(resume);
        if(ret > 0)
            return new ReturnDataAndInfo(true,"");
        else
            return new ReturnDataAndInfo(false,"保存失败，数据库操作错误");
    }


    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
}
