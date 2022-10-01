package com.springboot.university.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ErrorResponse {
    private String errorCode;
    private String message;
    private HttpStatus httpStatus;
}