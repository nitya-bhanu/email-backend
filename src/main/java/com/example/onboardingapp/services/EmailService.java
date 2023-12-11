package com.example.onboardingapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService{


    @Autowired
    private JavaMailSender javaMailSender;


    public  List<String> toArray;
    public String sendApprovalMessage(
            String to, String subject, String text) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("super-market-admin.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
        return "Email Sent successfully";
    }


    public String[] sendEmailIds(List<String> stringList){
        String[] emailIds=new String[stringList.size()];
        int x=0;
       for(String s:stringList){
           emailIds[x]=s;
           x++;
       }
       return emailIds;
    }


    public String sendAnnouncements(List<String>to, String subject, String text){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("super-market-admin.com");
        message.setTo(sendEmailIds(to));
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
        return "Email Sent successfully";
    }

    public void sendRejectionMessage (String to, String subject, String text){
        try{
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom("super-market-admin.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    public String sendOtp(String to){
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100000);
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("super-market-admin.com");
        message.setTo(to);
        message.setSubject("Your One time password");
        message.setText(Integer.toString(rand_int1));
        javaMailSender.send(message);
        return Integer.toString(rand_int1);
    }

}
