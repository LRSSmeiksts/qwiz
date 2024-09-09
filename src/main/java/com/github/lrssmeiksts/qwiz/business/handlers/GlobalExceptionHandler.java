package com.github.lrssmeiksts.qwiz.business.handlers;

import lombok.extern.log4j.Log4j2;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.module.ResolutionException;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnexpectedException.class)
    public ResponseEntity<String> handleUnexpectedException(UnexpectedException e){
     log.error("Unexpected error", e);
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(UserDatabaseException.class)
    public ResponseEntity<String> handleUserDatabaseException(UserDatabaseException e){
        log.error("Failed to save user to to persistence issue", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
