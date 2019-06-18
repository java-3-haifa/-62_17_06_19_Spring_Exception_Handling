package com.telrean.exceptionhandlingexample.exception;

import com.telrean.exceptionhandlingexample.controller.dto.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {CarNotFoundException.class})
    public ResponseEntity<?> handleBadRequest(RuntimeException ex, WebRequest request){
        return handleExceptionInternal(ex,"Wrong car id", new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }

    @ExceptionHandler(value = {WrongCarFormatException.class})
    public ResponseEntity<?> handleNotFound(RuntimeException ex, WebRequest request){
        String msg = "{\"error\":\"All cars fields required\"}";
        return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleOthersExceptions(RuntimeException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),new Date(),HttpStatus.FORBIDDEN.value());
        return new ResponseEntity<>(errorDetails,HttpStatus.FORBIDDEN);
    }
}
