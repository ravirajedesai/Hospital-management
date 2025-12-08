package com.practice.revision.model;

import org.springframework.http.HttpStatus;

public class ExceptionMessage {

    private HttpStatus status;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
//Constructed without parameter created..
    public ExceptionMessage() {
    }

// Constructed with parameter created..
    public ExceptionMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
