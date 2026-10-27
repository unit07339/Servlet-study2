package com.korai.servletstudy2.service;

import com.korai.servletstudy2.exception.DuplicatedException;
import com.korai.servletstudy2.model.User;
import com.korai.servletstudy2.repository.UserRepository;

import java.util.List;

// 아이디 중복 검사를 수행하고 이상이 없을 경우 저장소에 전달하는 비즈니스 로직 레이어 (싱글톤 패턴)

public class UserService {
    private static UserService instance;
    private UserRepository userRepository;

    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    } // 의존성 주입 형태의 생성자, 서비스 레이어가 레포지토리 레이어에 의존하여 일을 처리함을 의미

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService(UserRepository.getInstance());
        }
        return instance;
    } // UserService 역시 싱글톤으로 관리, 생성 시점에 UserRepository.getInstance를 전달해 레포지토리 싱글톤 객체와 연결

    public void register(User user) throws RuntimeException { // 컨트롤러로부터 사용자 등록 요청을 받는 메인 비즈니스 로직 메서드
        if (isDuplicatedUsername(user.getUsername())) { // DB(레퍼지토리)에 같은 아이디가 있는지 검사
            throw new DuplicatedException("이미 존재하는 사용자이름입니다."); // 중복된 아이디가 있으면 더 로직을 진행하지 않고, 예외를 던져서 상위(컨트롤러)로 에러 처리를 위임
        }
        userRepository.insert(user); // 중복 검사를 통과했을 때만 최종적으로 데이터 저장소에 회원 정보를 저장
    }

    public boolean isDuplicatedUsername(String username) { // boolean 일때는 메서드명 is 붙이기
        return userRepository.findByUsername(username) != null;
    } // findByUsername의 결과가 null이 아니면 이미 가입된 사람이 있다는 뜻으로 true를 반환하도록 작성

    public List<User> getUserAll() {
        return userRepository.findAll();
    }

}
