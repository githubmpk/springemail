package com.java.flash.mailerservice.emailnotification.controller;

import com.java.flash.mailerservice.emailnotification.emailservice.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/sendemail")
    public String sendEmailNotification() {
        emailSenderService.sendMail("kirthan.puttegowda@flash.co.za",
        "Test from spring boot application", "Spring boot test");
        return "Email sent successfully";
    }
}
