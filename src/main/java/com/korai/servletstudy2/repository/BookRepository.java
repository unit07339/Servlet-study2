package com.korai.servletstudy2.repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

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
        books.
    }
}
