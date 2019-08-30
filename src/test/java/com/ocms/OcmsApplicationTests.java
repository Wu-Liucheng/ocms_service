package com.ocms;

import com.ocms.entities.UserInfo;
import com.ocms.service.MailService;
import com.ocms.service.UserInfoService;
import com.ocms.service.impl.UserInfoServiceImpl;
import com.ocms.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OcmsApplicationTests {



    @Test
    public void contextLoads() {

    }
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() throws Exception {
        System.out.println(MD5Util.md5("admin"));
    }
}
