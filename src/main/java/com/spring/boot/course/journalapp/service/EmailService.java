package com.spring.boot.course.journalapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Slf4j
@Service
public class EmailService {

    private static JavaMailSender javaMailSender;

    public EmailService(JavaMailSender mailSender) {
        javaMailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            javaMailSender.send(mail);
        } catch (Exception e) {
            //log.info("Exception while sendEmail :{}",e.getMessage());
            System.out.println("Exception while sendEmail "+ e);
        }
    }

    public void sendVerificationEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Email Verification "+ subject);
        message.setText("To verify your email, please click the link below: "+ body);
        javaMailSender.send(message);
        System.out.println("Email has been sent");
    }



}