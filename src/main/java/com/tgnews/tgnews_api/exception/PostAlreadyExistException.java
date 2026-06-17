package com.tgnews.tgnews_api.exception;

public class PostAlreadyExistException extends RuntimeException{
    public PostAlreadyExistException(String message){
        super(message);
    }
}
