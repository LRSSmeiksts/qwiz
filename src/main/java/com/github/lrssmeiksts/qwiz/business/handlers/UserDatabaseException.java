package com.github.lrssmeiksts.qwiz.business.handlers;

public class UserDatabaseException extends RuntimeException{
    public UserDatabaseException(String message, Throwable cause){
        super(message,cause);
    }
}
