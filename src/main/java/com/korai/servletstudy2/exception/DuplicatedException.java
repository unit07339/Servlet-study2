package com.korai.servletstudy2.exception;


public class DuplicatedException extends RuntimeException {

    public DuplicatedException(String message) { // alt ins
        super(message);
    }
}
