package com.example.movieservice.exception.common;


import com.example.movieservice.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class BusinessException extends AbstractException {

    private static final long serialVersionUID = -128391243276L;
    public BusinessException(Object errorMessage, HttpStatus httpStatus) {
        super(errorMessage, httpStatus);
    }
}
