package com.example.spring_mongo.exception;

public class CustomException extends RuntimeException {
    private String msg;
    public CustomException(String msg){
        super(msg);
    }
}
