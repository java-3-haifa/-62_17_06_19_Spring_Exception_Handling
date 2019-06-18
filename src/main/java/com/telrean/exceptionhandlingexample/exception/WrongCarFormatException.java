package com.telrean.exceptionhandlingexample.exception;

public class WrongCarFormatException extends RuntimeException {
    public WrongCarFormatException(String message) {
        super(message);
    }
}
