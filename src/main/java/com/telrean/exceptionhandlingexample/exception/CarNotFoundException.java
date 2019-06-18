package com.telrean.exceptionhandlingexample.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String message) {
        super(message);
    }
}
