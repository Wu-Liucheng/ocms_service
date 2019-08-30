package com.ocms.action;
/***
 *
 *
 *                                                    __----~~~~~~~~~~~------___
 *                                   .  .   ~~//====......          __--~ ~~
 *                   -.            \_|//     |||\\  ~~~~~~::::... /~
 *                ___-==_       _-~o~  \/    |||  \\            _/~~-
 *        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 *    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 *  .~       .~       |   \\ -_    /  /-   /   ||      \   /
 * /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 * |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 *          '         ~-|      /|    |-~\~~       __--~~
 *                      |-~~-_/ |    |   ~\_   _-~            /\
 *                           /  \     \__   \/~                \__
 *                       _--~ _/ | .-~~____--~-/                  ~~==.
 *                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
 *                                 -_     ~\      ~~---l__i__i__i--~~_/
 *                                 _-~-__   ~)  \--______________--~~
 *                               //.-~~~-~_--~- |-------~~~~~~~~
 *                                      //.-~~~--\
 *                               神兽保佑
 *                              代码无BUG!
 */
import com.ocms.entities.CheckEmail;
import com.ocms.entities.ReturnDataAndInfo;
import com.ocms.entities.UserInfo;
import com.ocms.service.MailService;
import com.ocms.service.UserInfoService;
import com.ocms.util.GenerateVerifyCode;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class UserChangePassword {

    @Resource
    UserInfoService userInfoService;

    @Resource
    MailService mailService;

    @RequestMapping(value = "/send_change_password_verify_code",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo send(@RequestParam("username") String username){
        UserInfo userInfo = userInfoService.findByLoginName(username);
        if(userInfo == null){
            return new ReturnDataAndInfo(false,"发送失败，该用户不存在");
        }
        else {
            String email = userInfo.getEmail();
            String verifyCode = GenerateVerifyCode.generateSixRandom();
            int res = mailService.insertIntoCheckEmail(new CheckEmail(null,email,verifyCode,0,null,new Date(),null,null));
            if(res == 0)
                return new ReturnDataAndInfo(false,"发生了未知的错误...");
            else {
                try{
                    mailService.sendMail(email,"一封来自ocms的验证邮件",verifyCode);
                    return new ReturnDataAndInfo(true,"验证邮件已发送至"+
                            email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4")+
                            "，请及时查看");
                }
                catch (Exception e){
                    return new ReturnDataAndInfo(false,e.toString());
                }
            }
        }
    }

    @RequestMapping(value = "/change-pwd",method = RequestMethod.POST)
    @ResponseBody
    public ReturnDataAndInfo changePassword(@RequestParam("username") String username,
                                            @RequestParam("identify") String code,
                                            @RequestParam("pwd") String newPwd){
        UserInfo userInfo = userInfoService.findByLoginName(username);
        if(userInfo == null){
            return new ReturnDataAndInfo(false,"该用户不存在");
        }
        else {
            String email = userInfo.getEmail();
            CheckEmail checkEmail = mailService.findByEmailAndVerifyCode(email,code);
            if(checkEmail == null){
                return new ReturnDataAndInfo(false,"验证码错误");
            }
            else {
                Date compareDate = new Date(checkEmail.getCreateDate().getTime()+300000);
                if(compareDate.getTime() > new Date().getTime()){
                    if(MD5Util.verify(newPwd,userInfo.getPassword())){
                        return new ReturnDataAndInfo(false,"这就是原来的密码...");
                    }
                    else {
                        int res = userInfoService.changePassword(userInfo.getId(),MD5Util.md5(newPwd));
                        if(res > 0){
                            return new ReturnDataAndInfo(true,"修改成功");
                        }
                        else {
                            return new ReturnDataAndInfo(false,"修改失败");
                        }
                    }
                }
                else {
                    return new ReturnDataAndInfo(false,"验证码已过期");
                }
            }
        }
    }
}
