package com.springboot.university.exception;

import com.springboot.university.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class AppExceptionHandler {

   @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentException(StudentNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder().
                errorCode(UUID.randomUUID().toString()).
                message(exception.getMessage()).
                httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
