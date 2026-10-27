package com.korai.servletstudy2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String name;

    // copy 생성자
    // 완전 깊은 복사
    // 기존 User 객체의 값을 바탕으로 완전히 새로운 객체를 복사 -> 원본 데이터가 외부에서 의도치 않게 수정되는 위험을 방지
    public User(User other) {
        this.id = other.id;
        this.username = other.username;
        this.password = other.password;
        this.name = other.name;
    }
}
