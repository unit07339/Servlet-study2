package com.korai.servletstudy2.service;

// 4. 도서명 중복 검사를 거쳐 등록을 수행하는 비즈니스 로직을 작성

import com.korai.servletstudy2.exception.DuplicatedException;
import com.korai.servletstudy2.model.Book;
import com.korai.servletstudy2.repository.BookRepository;

import java.util.List;

public class BookService {
    private static BookService instance;
    private BookRepository bookRepository;

    private BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService(BookRepository.getInstance());
        }
        return instance;
    }

    public void register(Book book) throws RuntimeException {
        if (isDuplicatedBookName(book.getBookName())) {
            throw new DuplicatedException("이미 존재하는 도서명입니다.");
        }
        bookRepository.insert(book);
    }

    public boolean isDuplicatedBookName(String bookName) {
        return bookRepository.findByBookName(bookName) != null;
    }

    public List<Book> getBookAll(){
        return bookRepository.findAll();
    }
}
// BookRegisterController



/*
package com.korai.servletstudy2.service; // 패키지 위치 지정

import com.korai.servletstudy2.exception.DuplicatedException; // 예외 클래스 가져오기
import com.korai.servletstudy2.model.Book; // 모델 클래스 가져오기
import com.korai.servletstudy2.repository.BookRepository; // 리포지토리 가져오기

import java.util.List; // List 가져오기

public class BookService {
    private static BookService instance; // 싱글톤 패턴 적용용 인스턴스 변수
    private BookRepository bookRepository; // 의존성 주입: DB 처리를 담당할 리포지토리 객체 변수

    // private 생성자: 외부 생성을 막고, 싱글톤 리포지토리를 전달받습니다.
    private BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository; // 전달받은 리포지토리를 변수에 저장합니다.
    }

    // 싱글톤 객체 반환 메서드
    public static BookService getInstance() {
        if (instance == null) { // 인스턴스가 없으면
            instance = new BookService(BookRepository.getInstance()); // 싱글톤 리포지토리를 주입하며 생성합니다.
        }
        return instance; // 인스턴스를 반환합니다.
    }

    // 도서 등록 처리 메서드
    public void register(Book book) throws RuntimeException {
        if (isDuplicatedBookName(book.getBookName())) { // 도서명이 이미 존재하면
            throw new DuplicatedException("이미 존재하는 도서명입니다."); // 커스텀 예외를 발생시킵니다.
        }
        bookRepository.insert(book); // 중복이 아니면 리포지토리에 저장합니다.
    }

    // 도서명 중복 여부 확인 메서드
    public boolean isDuplicatedBookName(String bookName) {
        return bookRepository.findByBookName(bookName) != null; // 조회 결과가 null이 아니면 true(중복) 반환
    }

    // 전체 도서 목록 가져오는 메서드
    public List<Book> getBookAll() {
        return bookRepository.findAll(); // 리포지토리의 findAll을 호출하여 전달합니다.
    }
}
*/