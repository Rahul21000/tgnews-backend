package com.tgnews.tgnews_api.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String message){
        super(message);
    }
}
