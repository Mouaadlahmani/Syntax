package com.mouad.syntax.exeption;

public class CertificateAlreadyExistsException extends RuntimeException {
    public CertificateAlreadyExistsException(String message) {
        super(message);
    }
}