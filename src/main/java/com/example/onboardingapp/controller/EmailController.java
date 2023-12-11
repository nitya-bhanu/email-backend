package com.example.onboardingapp.controller;

import com.example.onboardingapp.request.EmailAll;
import com.example.onboardingapp.request.EmailInfo;
import com.example.onboardingapp.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("")
    public String sendApprovalMessage(
            @RequestBody EmailInfo emailInfo) {
       return  emailService.sendApprovalMessage(emailInfo.toEmailAddress,emailInfo.subjectEmail,emailInfo.text);
    }

    @PostMapping(value = "/announcements")
    public String sendAnnouncements(@RequestBody EmailAll emailAll){
        return emailService.sendAnnouncements(emailAll.toEmailAddress,emailAll.subjectEmail,emailAll.text);
    }
}
