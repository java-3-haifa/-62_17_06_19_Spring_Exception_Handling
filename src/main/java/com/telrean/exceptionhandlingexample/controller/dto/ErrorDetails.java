package com.telrean.exceptionhandlingexample.controller.dto;

import java.util.Date;

public class ErrorDetails {
    public String message;
    public Date date;
    public int code;

    public ErrorDetails(String message, Date date, int code) {
        this.message = message;
        this.date = date;
        this.code = code;
    }
}
