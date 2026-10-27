package com.korai.servletstudy2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 1. 주어진 Book 클래스에 저장소 데이터 오염을 방지하기 위한 깊은 복사 생성자를 추가하여 마무리

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String bookName;
    private int price;

    public Book(Book other) {
        this.id = other.id;
        this.bookName = other.bookName;
        this.price = other.price;
    }
}
// DuplicatedException




/*
package com.korai.servletstudy2.model; // 패키지 위치 지정

import lombok.AllArgsConstructor; // 모든 필드를 포함하는 생성자를 자동 작성해 주는 롬복 라이브러리
import lombok.Data; // Getter, Setter, toString, equals 등을 자동 작성해 주는 롬복 라이브러리
import lombok.NoArgsConstructor; // 기본 생성자(매개변수 없음)를 자동 작성해 주는 롬복 라이브러리

@Data // lombok: getId(), setBookName() 등의 메서드를 자동으로 만들어 줍니다.
@NoArgsConstructor // lombok: public Book() {} 기본 생성자를 자동으로 만들어 줍니다.
@AllArgsConstructor // lombok: public Book(int id, String bookName, int price) 생성자를 만들어 줍니다.
public class Book { // 도서 데이터의 틀이 되는 클래스 선언
    private int id; // 도서를 구분할 고유 번호 (PK 역할)
    private String bookName; // 도서 제목
    private int price; // 도서 가격

    // 깊은 복사(Deep Copy) 생성자: 저장소에서 데이터를 꺼내줄 때 원본 데이터를 보호하기 위해 작성합니다.
    public Book(Book other) { // 다른 Book 객체를 매개변수로 받아 똑같은 값을 가진 새 객체를 만듭니다.
        this.id = other.id; // 기존 객체의 id 복사
        this.bookName = other.bookName; // 기존 객체의 bookName 복사
        this.price = other.price; // 기존 객체의 price 복사
    }
}
*/
