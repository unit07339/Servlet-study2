package com.korai.servletstudy2.repository;

import com.korai.servletstudy2.model.Book;

import java.util.ArrayList;
import java.util.List;

// 3. 도서 데이터(bookName) 중복 확인과 도서 추가 및 목록 조회 기능을 제공하는 메모리 저장소를 싱글톤 패턴으로 구현

public class BookRepository {
    private static BookRepository instance;
    private int lastId;
    private List<Book> books;

    private BookRepository() {
        lastId = 1;
        books = new ArrayList<>();
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public void insert(Book book) {
        book.setId(lastId++);
        books.add(book);
    }

    public Book findByBookName(String bookName) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookName().equals(bookName)) {
                return books.get(i);
            }
        }
        return null;
    }

    public List<Book> findAll() {
        return books.stream().map(book -> new Book(book)).toList();
    }
}
// BookService



/*
package com.korai.servletstudy2.repository; // 패키지 위치 지정

import com.korai.servletstudy2.model.Book; // 우리가 정의한 Book 모델을 가져옵니다.

import java.util.ArrayList; // 가변 리스트 구현체 ArrayList를 가져옵니다.
import java.util.List; // 리스트 인터페이스를 가져옵니다.

public class BookRepository {
    private static BookRepository instance; // 싱글톤 패턴: 앱 전체에서 단 1개만 존재할 인스턴스 변수
    private int lastId; // 새로 등록되는 도서에 부여할 자동 증가 ID 값 (1, 2, 3...)
    private List<Book> books; // 도서 객체들을 저장해 둘 메모리 리스트 변수

    // private 생성자: 외부에서 new BookRepository()로 생성하지 못하게 막습니다.
    private BookRepository() {
        lastId = 1; // 도서 ID 시작값을 1로 설정합니다.
        books = new ArrayList<>(); // 도서를 담을 리스트 객체를 생성합니다.
    }

    // 싱글톤 객체 반환 메서드: 어디서든 동일한 BookRepository 인스턴스를 사용하게 합니다.
    public static BookRepository getInstance() {
        if (instance == null) { // 만약 생성된 객체가 없다면
            instance = new BookRepository(); // 새로 하나 생성합니다.
        }
        return instance; // 생성되어 있는 객체를 반환합니다.
    }

    // 도서 저장 메서드
    public void insert(Book book) {
        book.setId(lastId++); // 도서에 현재 ID를 할당한 후, lastId 값을 1 증가시킵니다.
        books.add(book); // 리스트에 도서 객체를 추가합니다.
    }

    // 도서명으로 도서 검색 메서드 (중복 체크 시 사용)
    public Book findByBookName(String bookName) {
        for (int i = 0; i < books.size(); i++) { // 리스트의 모든 도서를 순회합니다.
            if (books.get(i).getBookName().equals(bookName)) { // 가져온 도서의 이름과 찾으려는 이름이 같다면
                return books.get(i); // 해당 도서 객체를 반환합니다.
            }
        }
        return null; // 찾는 도서가 없으면 null을 반환합니다.
    }

    // 전체 도서 목록 조회 메서드
    public List<Book> findAll() {
        // 복사 생성자(new Book(book))를 활용해 원본 리스트를 보호하며 복사본 목록을 반환합니다.
        return books.stream().map(book -> new Book(book)).toList();
    }
}
*/