package com.spring.boot.course.journalapp.service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;

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

    // To verify your email, please click the link below: Sentiment for last 7 days HAPPY
    public void sendVerificationEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Email Verification: "+ subject);
        message.setText("To verify your email, please click the link below: "+ body);
        javaMailSender.send(message);
        System.out.println("Email has been sent");

        /*Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.googlemail.com");
        props.put("mail.from", "myemail@gmail.com");
        Session session = Session.getInstance(props, null);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO,"myemail@hotmail.com");
            msg.setSubject("JavaMail hello world example");
            msg.setSentDate(new Date());
            msg.setText("Hello, world!\n");
            Transport.send(msg);
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }*/
    }



}