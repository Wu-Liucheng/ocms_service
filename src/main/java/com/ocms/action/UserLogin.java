package com.ocms.action;
/***
 *_______________#########_______________________
 *______________############_____________________
 *______________#############____________________
 *_____________##__###########___________________
 *____________###__######_#####__________________
 *____________###_#######___####_________________
 *___________###__##########_####________________
 *__________####__###########_####_______________
 *________#####___###########__#####_____________
 *_______######___###_########___#####___________
 *_______#####___###___########___######_________
 *______######___###__###########___######_______
 *_____######___####_##############__######______
 *____#######__#####################_#######_____
 *____#######__##############################____
 *___#######__######_#################_#######___
 *___#######__######_######_#########___######___
 *___#######____##__######___######_____######___
 *___#######________######____#####_____#####____
 *____######________#####_____#####_____####_____
 *_____#####________####______#####_____###______
 *______#####______;###________###______#________
 *________##_______####________####______________
 */
import com.ocms.entities.UserInfo;
import com.ocms.service.UserInfoService;
import com.ocms.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class UserLogin {


    @Resource
    UserInfoService userInfoService;

    @RequestMapping(value = "/login_action",method = RequestMethod.POST)
    @ResponseBody
    public Boolean userLogin(@RequestParam(value = "type",required = false) String type,
                             @RequestParam(value = "account",required = false) String account,
                             @RequestParam(value = "password",required = false) String password){
        //System.out.println(type+" "+account+" "+password);
        if(type.equalsIgnoreCase("login")){
            UserInfo userInfo = userInfoService.findByLoginName(account);
            if(userInfo!=null && MD5Util.verify(password,userInfo.getPassword()))
                return true;
            return false;
        }
        else {
            return false;
        }
    }

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

}
