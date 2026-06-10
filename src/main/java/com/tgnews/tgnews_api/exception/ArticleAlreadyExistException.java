package com.tgnews.tgnews_api.exception;

public class ArticleAlreadyExistException extends RuntimeException{
    public ArticleAlreadyExistException(String message){
        super(message);
    }
}
