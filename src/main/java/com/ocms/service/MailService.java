package com.ocms.service;

import com.ocms.entities.CheckEmail;

import java.util.List;

public interface MailService {


    /**
     * 发送邮件
     * @param to 邮件收件人
     * @param subject 邮件主题
     * @param verifyCode 邮件验证码
     */
    public void sendMail(String to, String subject, String verifyCode);

    public void sendEmail(String to,String subject,String content);

    public int insertIntoCheckEmail(CheckEmail record);

    CheckEmail findByEmailAndVerifyCode(String email, String code);

}
