package com.tgnews.tgnews_api.exception;

import java.io.IOException;

public class ImageUploadException extends RuntimeException {
    public ImageUploadException(String message){
        super(message);
    }
}
