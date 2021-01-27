package com.java.flash.mailerservice.emailnotification.controller;

import com.java.flash.mailerservice.emailnotification.domain.MailModel;
import com.java.flash.mailerservice.emailnotification.emailservice.EmailSenderService;
import com.java.flash.mailerservice.emailnotification.exception.SendFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class NotificationController {

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/sendemail")
    public String sendEmailNotification(@RequestParam String toEmail, @RequestParam String subject,
                                        @RequestParam String message) {
        try{
            emailSenderService.sendMail(toEmail, subject, message);
            return "Email sent successfully";
        } catch(SendFailedException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @PostMapping("/sendmail")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendEmailNotification(@RequestBody MailModel model) {
        try {
            emailSenderService.sendMail(model.getEmailId(), model.getSubject(), model.getMessage());
            return "Email sent successfully";
        } catch(SendFailedException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }
}
