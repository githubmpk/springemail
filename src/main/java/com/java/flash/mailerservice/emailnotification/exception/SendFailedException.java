package com.java.flash.mailerservice.emailnotification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Address")
public class SendFailedException extends Exception {
    public SendFailedException(String message) {
        super(message);
    }
}
