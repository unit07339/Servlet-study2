package com.korai.servletstudy2.controller;


// 8. 초기 데이터 2건을 등록하고, 도서 전체 목록을 받아 book-list.jsp로 전달함
// 9. book-list.jsp로 이동 -> 도서 목록 데이터를 받아 HTML 테이블로 바인딩하여 보여주는 화면

import com.korai.servletstudy2.model.Book;
import com.korai.servletstudy2.service.BookService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/list")
public class BookListController extends HttpServlet {
    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = BookService.getInstance();
        bookService.register(new Book(0, "멘토시리즈 자바", 30000));
        bookService.register(new Book(0, "잠자는 숲", 25000));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookList", bookService.getBookAll());
        req.getRequestDispatcher("/WEB-INF/views/book-list.jsp").forward(req, resp);
    }
}
