package com.github.lrssmeiksts.qwiz.business.handlers;

public class InvalidIdException extends RuntimeException{
    public InvalidIdException(String message){
        super(message);
    }
}
