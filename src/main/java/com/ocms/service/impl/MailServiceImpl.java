package com.ocms.service.impl;

import com.ocms.dao.CheckEmailMapper;
import com.ocms.entities.CheckEmail;
import com.ocms.service.MailService;
import com.ocms.util.EntityToHashMapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Resource
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Resource
    private CheckEmailMapper checkEmailMapper;

    @Override
    public void sendMail(String to, String subject, String verifyCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText("[ocms]您的验证码是"+verifyCode+",5分钟内有效,请勿泄露。");
        mailSender.send(message);
    }

    @Override
    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    public int insertIntoCheckEmail(CheckEmail record) {
        return checkEmailMapper.insertSelective(record);
    }

    @Override
    public CheckEmail findByEmailAndVerifyCode(String email, String code) {
        CheckEmail checkEmail = new CheckEmail(email,code);
        return checkEmailMapper.selectByEmailAndCode(EntityToHashMapUtil.transfer(checkEmail));
    }
}
