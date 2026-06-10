package com.tgnews.tgnews_api.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String message;
    private int statusCode;
    private String status;
    private Object body;
}
