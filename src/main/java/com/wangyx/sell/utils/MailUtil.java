package com.wangyx.sell.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
public class MailUtil {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String emailForm,String[] emailTo,String title,String context){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(emailForm);
            helper.setTo(emailTo);
            helper.setSubject(title);//主题
            helper.setText(context);//正文
            mailSender.send(mimeMessage);
        } catch (MessagingException e1) {
            log.error("【邮件发送】发送失败,=>{}",e1);
            e1.printStackTrace();
        }
    }
}
