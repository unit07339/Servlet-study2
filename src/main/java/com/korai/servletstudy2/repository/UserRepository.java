package com.korai.servletstudy2.repository;

import com.korai.servletstudy2.model.User;

import java.util.ArrayList;
import java.util.List;

// 메모리(ArrayList)를 데이터베이스처럼 활용하여 회원 데이터의 저장 및 조회를 담당(싱글톤 패턴)

public class UserRepository {
    private static UserRepository instance; // 싱글톤 패턴을 적용하여 프로그램 전체에서 단 하나의 UserRepository 객체만 존재하고 공유되도록 선언한 정적 변수
    private int lastId; // 회원이 추가될 때마다 PK 값을 1씩 늘려주기 위해 관리하는 카운터 변수
    private List<User> users; // 실제 데이터를 서버 메모리 상에 보관하기 위해 선택한 컬렉션

    private UserRepository() { // 생성자를 private로 묶어 외부에서 new로 객체를 새로만드는 것을 금지, 데이터 저장소는 무조건 싱글톤으로 유지되어야 등록된 회원 목록이 유지되기 때문
        lastId = 1;
        users = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    } // 외부에서 이 리포지토리를 사용하기 위한 유일한 통로, instance가 null일 때만 단 한 번 객체를 생성하고, 이미 존재하면 만들어둔 인스턴스를 반환


        // 회원 저장 (ID 1씩 자동 증가)
    public void insert(User user) { // insert: 고유 ID를 부여한 후 리스트에 수집
        user.setId(lastId++); // 유저가 등록될 때 lastId 값을 객체에 넣어준 뒤, 다음 유저를 위해 lastId를 1 증가시킴
        users.add(user); // ID가 할당된 유저 객체를 메모리 리스트에 저장함
    }

    // 아이디로 회원 검색
    public User findByUsername(String username) { // 아이디 중복 체크 시 사용

//        중복체크
//        for (User user : users) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
//        return null;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return users.get(i);
            }
        }
        return null;
    } // 리스트 전체를 순회하면서 equals로 전달받은 아이디와 같은 회원이 있는지 찾음

    public User findById(int id) { // 고유 번호(PK)로 회원을 찾을 때 사용
        // equals은 문자열 비교, int는 == 으로 비교

//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getId() == id) {
//                return users.get(i);
//            }
//        }
//        return null;


//        for (User user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;

        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseGet(() -> null);
    }

    // 원본 데이터 보호를 위해 복사본 목록 반환
    public List<User> findAll() {
        return users.stream().map(user -> new User(user)).toList();
    } // users 원본 리스트를 그대로 반환하면 외부에서 리스트 안의 데이터를 직접 수정해버릴 수 있음
    // User 클래스의 복사 생성자(new User(user))를 이용해 완전히 새로운 객체들로 이루어진 리스트를 만들어 반환하여 원본을 보호

}
