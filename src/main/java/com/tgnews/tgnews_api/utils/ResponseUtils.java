package com.tgnews.tgnews_api.utils;

import com.tgnews.tgnews_api.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtils {
    public ResponseEntity<ResponseDto> handleResponseInPayload(Object body, String message, int statusCode, HttpStatus status) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(message);
        responseDto.setStatusCode(statusCode);
        responseDto.setStatus(status.getReasonPhrase());
        responseDto.setBody(body);
        return new ResponseEntity<>(responseDto, status);
    }
}
