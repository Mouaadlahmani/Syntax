package com.mouad.syntax.exeption;

public class CoursNotFoundException extends RuntimeException {
    public CoursNotFoundException(String message) {
        super(message);
    }
}
