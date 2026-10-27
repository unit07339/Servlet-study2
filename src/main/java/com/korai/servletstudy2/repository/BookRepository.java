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
