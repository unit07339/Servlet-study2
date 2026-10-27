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