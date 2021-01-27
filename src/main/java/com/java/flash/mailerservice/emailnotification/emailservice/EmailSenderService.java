package com.java.flash.mailerservice.emailnotification.emailservice;

import com.java.flash.mailerservice.emailnotification.exception.SendFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmailSenderService  {

    private JavaMailSender javaMailSender;

    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) throws SendFailedException {
        MailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("kirthan.puttegowda@pathcare.co.za");

        javaMailSender.send((SimpleMailMessage) mailMessage);
    }

}
