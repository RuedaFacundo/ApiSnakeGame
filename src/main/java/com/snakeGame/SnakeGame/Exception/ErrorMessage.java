package com.snakeGame.SnakeGame.Exception;

import org.springframework.http.HttpStatus;

public class ErrorMessage extends RuntimeException {

    private String message;
    private final HttpStatus httpStatus;
    private String detail;
    private String code;
    private String path;

    public ErrorMessage(String message, String detail, String code, String path, HttpStatus httpStatus) {
        this.message = message;
        this.detail = detail;
        this.code = code;
        this.path = path;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public String getCode() {
        return code;
    }

    public String getPath() {
        return path;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
