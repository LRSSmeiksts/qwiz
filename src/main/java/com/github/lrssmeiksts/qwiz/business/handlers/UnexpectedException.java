package com.github.lrssmeiksts.qwiz.business.handlers;

public class UnexpectedException extends RuntimeException{
    public UnexpectedException(String message, Throwable cause){
        super(message, cause);
    }
}
