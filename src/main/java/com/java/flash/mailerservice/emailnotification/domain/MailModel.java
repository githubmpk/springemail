package com.java.flash.mailerservice.emailnotification.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class MailModel {

    private String emailId;
    private String subject;
    private String message;

    public MailModel(){}

    public MailModel(String emailId, String subject, String message) {
        this.emailId = emailId;
        this.subject = subject;
        this.message = message;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
