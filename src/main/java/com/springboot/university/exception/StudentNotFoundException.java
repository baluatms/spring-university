package com.springboot.university.exception;

public class StudentNotFoundException extends Exception{

    public StudentNotFoundException(String message) {
        super(message);
    }
}
