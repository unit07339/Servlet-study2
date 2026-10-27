package com.korai.servletstudy2.exception;

// 이미 존재하는 아이디로 가입 시도를 할 때 발생하는 전용 예외 클래스
// 2. 중복 처리용 예외 클래스
public class DuplicatedException extends RuntimeException { // 예외 메시지를 부모 클래스로 전달

    public DuplicatedException(String message) { // alt ins
        super(message);
    }
}
// BookRepository

// public class DuplicatedException extends RuntimeException
// 자바의 표준 예외 대신에 '아이디 중복'이라는 명확한 비즈니스 에러 상황을 표현하기 위해서 커스텀 예외 클래스를 정의
// RuntimeException을 상속받아 예외처리(try-catch)를 강제하지 않는 Unchecked Exception으로 동작

/*
* public DuplicatedException(String message)
* 예외가 발생한 상세 원인을 문자열로 받아 부모 클래스(super(message))로 전달
* 이렇게 전달된 메시지는 나중에 e.getMassage로 꺼내어 클라이언트에게 전송할 응답 메시지로 활용 가능
*/



/*
package com.korai.servletstudy2.exception; // 패키지 위치 지정

// RuntimeException을 상속받아 실행 중에 발생시킬 예외 클래스를 정의합니다.
public class DuplicatedException extends RuntimeException {

    // 예외 발생 시 보여줄 에러 메시지를 전달받는 생성자
    public DuplicatedException(String message) {
        super(message); // 전달받은 메시지를 부모 클래스(RuntimeException)에 넘겨 저장합니다.
    }
}
*/