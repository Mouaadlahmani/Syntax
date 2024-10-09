package com.mouad.syntax.exeption;

public class CertificatNotFoundException extends RuntimeException {
    public CertificatNotFoundException(String message) {
        super(message);
    }
}
