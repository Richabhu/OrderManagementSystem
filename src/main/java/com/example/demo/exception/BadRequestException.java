package com.example.demo.exception;

import org.springframework.http.HttpStatus;


public class BadRequestException extends RuntimeException {

    public static final HttpStatus status = HttpStatus.BAD_REQUEST;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
