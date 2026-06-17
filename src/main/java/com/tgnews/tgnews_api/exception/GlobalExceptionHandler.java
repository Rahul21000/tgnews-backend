package com.tgnews.tgnews_api.exception;

import com.tgnews.tgnews_api.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleGeneralException(Exception e){
        ResponseDto responseMessageJSON = new ResponseDto();
        responseMessageJSON.setMessage(e.getMessage());
        responseMessageJSON.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseMessageJSON.setStatus("INTERNAL SERVER ERROR");
        return new ResponseEntity<>(responseMessageJSON,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> errors = new LinkedHashMap<>();
        for (FieldError error : fieldErrors) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PostAlreadyExistException.class)
    public ResponseEntity<ResponseDto> handleArticleAlreadyExistException(PostAlreadyExistException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(e.getMessage());
        responseDto.setStatusCode(HttpStatus.CONFLICT.value());
        responseDto.setStatus("CONFLICT");
        return new ResponseEntity<>(responseDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ResponseDto> handleArticleNotFoundException(PostNotFoundException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(e.getMessage());
        responseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseDto.setStatus("NOT FOUND");
        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(e.getMessage());
        responseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseDto.setStatus("BAD REQUEST");
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
