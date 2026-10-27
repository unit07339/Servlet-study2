package com.korai.servletstudy2.controller;


// 8. 초기 데이터 2건을 등록하고, 도서 전체 목록을 받아 book-list.jsp로 전달함

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

// 9. book-list.jsp로 이동 -> 도서 목록 데이터를 받아 HTML 테이블로 바인딩하여 보여주는 화면





/*
package com.korai.servletstudy2.controller; // 패키지 위치 지정

import com.korai.servletstudy2.model.Book; // 모델 클래스 가져오기
import com.korai.servletstudy2.service.BookService; // 서비스 클래스 가져오기

import javax.servlet.ServletConfig; // 서블릿 설정
import javax.servlet.ServletException; // 예외 클래스
import javax.servlet.annotation.WebServlet; // 서블릿 어노테이션
import javax.servlet.http.HttpServlet; // 서블릿 상속
import javax.servlet.http.HttpServletRequest; // 요청 객체
import javax.servlet.http.HttpServletResponse; // 응답 객체
import java.io.IOException; // 입출력 예외

@WebServlet("/book/list") // 브라우저가 /book/list 로 접근할 때 동작합니다.
public class BookListController extends HttpServlet {
    private BookService bookService; // 도서 서비스 변수

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = BookService.getInstance(); // 서비스 싱글톤 인스턴스 할당
        // 앱 구동 시 초기 데이터 2건을 미리 등록해 둡니다.
        bookService.register(new Book(0, "멘토시리즈 자바", 30000));
        bookService.register(new Book(0, "잠자는 숲", 25000));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 전체 도서 목록을 가져와 request 객체의 보관함에 "bookList"라는 이름의 key로 담아둡니다.
        req.setAttribute("bookList", bookService.getBookAll());
        // 데이터 보관함을 품은 요청(req)과 응답(resp)을 book-list.jsp 화면으로 넘겨줍니다 (forward).
        req.getRequestDispatcher("/WEB-INF/views/book-list.jsp").forward(req, resp);
    }
}
*/