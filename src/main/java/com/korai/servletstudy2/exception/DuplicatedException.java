package com.korai.servletstudy2.exception;

// 2. 중복 처리용 예외 클래스
public class DuplicatedException extends RuntimeException {

    public DuplicatedException(String message) { // alt ins
        super(message);
    }
}
