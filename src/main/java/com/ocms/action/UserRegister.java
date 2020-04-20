package com.ocms.action;

import com.ocms.dao.CheckEmailMapper;
import com.ocms.entities.CheckEmail;
import com.ocms.entities.Resume;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.entities.UserInfo;
import com.ocms.service.MailService;
import com.ocms.service.ResumeService;
import com.ocms.service.UserInfoService;
import com.ocms.task.SendMailTask;
import com.ocms.util.GenerateVerifyCode;
import com.ocms.util.MD5Util;
import com.ocms.util.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.Date;

@Controller
public class UserRegister {

    @Resource
    UserInfoService userInfoService;

//    @Resource
//    MailService mailService;

    @Resource
    ResumeService resumeService;

    @Resource
    SendMailTask sendMailTask;

    @Resource
    RedisUtil redisUtil;

    @RequestMapping(value = "/login_name_is_existed",method = RequestMethod.POST)
    @ResponseBody
    public Boolean loginNameIsExisted(@RequestParam("username") String username){
        UserInfo userInfo = userInfoService.findByLoginName(username);
        if(userInfo == null)
            return false;
        else
            return true;
    }

    @RequestMapping(value = "/send_register_vertification",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo sendVertification(@RequestParam("email") String email){
        UserInfo userInfo = userInfoService.findByEmail(email);
        if(userInfo == null)
        {
            String verifyCode = GenerateVerifyCode.generateSixRandom();
            //int res = mailService.insertIntoCheckEmail(new CheckEmail(null,email,verifyCode,0,null,new Date(),null,null));
            boolean res = redisUtil.set(email,verifyCode,300);
            if(!res)
                return new ReturnDataAndInfo(false,"发送失败。");
            else
            {
                try
                {
                    //mailService.sendMail(email,"一封来自ocms的验证邮件",verifyCode);
                    sendMailTask.send(email,verifyCode);
                    return new ReturnDataAndInfo(true,"");
                }
                catch (Exception e){
                    return new ReturnDataAndInfo(false,e.toString());
                }
            }
        }
        else
        {
            return new ReturnDataAndInfo(false,"该邮箱已经被注册。");
        }
    }

    @RequestMapping(value = "/register_check_verify_code",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo check(@RequestParam("email") String email,
                                   @RequestParam("identifyCode") String verifyCode){
        //CheckEmail checkEmail = mailService.findByEmailAndVerifyCode(email,verifyCode);
        String code = (String)redisUtil.get(email);
        if(verifyCode==null||!verifyCode.equals(code))
            return new ReturnDataAndInfo(false,"验证码或者邮箱错误");
        else
        {
            /*Date compareDate = new Date(checkEmail.getCreateDate().getTime()+300000);
            if(compareDate.getTime() > new Date().getTime()){
                return new ReturnDataAndInfo(true,"");
            }
            else {
                return new ReturnDataAndInfo(false,"验证码已超时");
            }*/
            return new ReturnDataAndInfo(true,"");
        }
    }

    @RequestMapping(value = "/register_action",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo registerAction(@RequestParam("username") String loginName,
                                            @RequestParam("password") String password,
                                            @RequestParam("email") String email,
                                            @RequestParam("name") String name,
                                            @RequestParam("sex") Boolean sex,
                                            @RequestParam("phone") String mobile,
                                            @RequestParam("qq") String qq){
        UserInfo userInfo = new UserInfo(null,loginName, MD5Util.md5(password),email,null,null,null,new Date());
        int res0 = userInfoService.addUser(userInfo);
        if(res0 > 0){
            Resume resume = new Resume(userInfo.getId(),mobile,null,name,email,qq,null,
                    null,null,null,null,null,
                    null,null,null,null,null,
                    null,null,sex,null,null,null,
                    null,null,null);
            int res1 = resumeService.addResume(resume);
            if(res1 > 0){
                return new ReturnDataAndInfo(true,null);
            }
            else {
                return new ReturnDataAndInfo(false,"注册失败。。。");
            }
        }
        else {
            return new ReturnDataAndInfo(false,"注册失败。。。");
        }
    }
}
/***
 *                  ___====-_  _-====___
 *            _--^^^#####//      \\#####^^^--_
 *         _-^##########// (    ) \\##########^-_
 *        -############//  |\^^/|  \\############-
 *      _/############//   (@::@)   \\############\_
 *     /#############((     \\//     ))#############\
 *    -###############\\    (oo)    //###############-
 *   -#################\\  / VV \  //#################-
 *  -###################\\/      \//###################-
 * _#/|##########/\######(   /\   )######/\##########|\#_
 * |/ |#/\#/\#/\/  \#/\##\  |  |  /##/\#/  \/\#/\#/\#| \|
 * `  |/  V  V  `   V  \#\| |  | |/#/  V   '  V  V  \|  '
 *    `   `  `      `   / | |  | | \   '      '  '   '
 *                     (  | |  | |  )
 *                    __\ | |  | | /__
 *                   (vvv(VVV)(VVV)vvv)
 *                        神兽保佑
 *                       代码无BUG!
 */