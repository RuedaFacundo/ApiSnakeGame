package com.snakeGame.SnakeGame.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlayerNotFound.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> contactoExistenteException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("Play not found", e.getMessage(), "1", req.getRequestURI()), HttpStatus.NOT_FOUND);
    }
}
