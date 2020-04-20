package com.ocms.task;

import com.ocms.service.MailService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Wu Liucheng
 * @date 2020/4/20 12:35 下午
 * @description
 */

@Component
public class SendMailTask {

    @Resource
    MailService mailService;


    @Async("taskAsyncExecutor")
    public void send(String email,String verifyCode){
        mailService.sendMail(email,"一封来自ocms的验证邮件",verifyCode);
    }
}
