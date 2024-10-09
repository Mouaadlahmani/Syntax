package com.mouad.syntax.exeption;

public class LeconNotFoundException extends RuntimeException {
    public LeconNotFoundException(String message) {
        super(message);
    }
}
