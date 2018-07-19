package com.bootdo.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * @author mading
 * @desc
 * @date 2018/7/17
 **/

//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object constraintViolationExceptionHandler(Exception e) {
        System.out.println(e.toString());
        return "111";
    }

}
