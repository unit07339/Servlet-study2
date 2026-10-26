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


