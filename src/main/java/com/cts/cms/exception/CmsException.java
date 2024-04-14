package com.cts.cms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CmsException extends RuntimeException {

    @Getter
    private HttpStatus status;
    private String message;

    public CmsException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public CmsException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
