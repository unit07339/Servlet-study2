package com.korai.servletstudy2.controller;


// 7. 클라이언트가 전송한 도서 JSON 데이터(bookName, price)를 받아 서비스를 통해 저장하고 응답을 돌려줌

import com.korai.servletstudy2.exception.DuplicatedException;
import com.korai.servletstudy2.model.Book;
import com.korai.servletstudy2.service.BookService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/books")
public class BookApiController extends HttpServlet {
    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = BookService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = objectMapper.readValue(req.getInputStream(), Book.class);

        System.out.println("도서 등록 요청 들어옴");
        System.out.println(book);

        try {
            bookService.register(book);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(200);
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", "도서 등록 성공"
            )));
        } catch (DuplicatedException e) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(400);
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", e.getMessage()
            )));
        }
    }
}

// BookListController



/*
package com.korai.servletstudy2.controller; // 패키지 위치 지정

import com.korai.servletstudy2.exception.DuplicatedException; // 예외 가져오기
import com.korai.servletstudy2.model.Book; // 모델 가져오기
import com.korai.servletstudy2.service.BookService; // 서비스 가져오기
import tools.jackson.databind.ObjectMapper; // Jackson JSON 변환 라이브러리 가져오기

import javax.servlet.ServletConfig; // 서블릿 설정 가져오기
import javax.servlet.ServletException; // 예외 클래스 가져오기
import javax.servlet.annotation.WebServlet; // 서블릿 어노테이션 가져오기
import javax.servlet.http.HttpServlet; // 서블릿 기본 상속 클래스
import javax.servlet.http.HttpServletRequest; // 요청 객체
import javax.servlet.http.HttpServletResponse; // 응답 객체
import java.io.IOException; // 입출력 예외
import java.util.Map; // Map 데이터 구조 가져오기

@WebServlet("/api/books") // 브라우저나 fetch가 /api/books 로 데이터 요청을 보내면 작동합니다.
public class BookApiController extends HttpServlet {
    private BookService bookService; // 비즈니스 로직을 처리할 서비스 객체 변수

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = BookService.getInstance(); // 서블릿 생성 시 서비스를 싱글톤으로 받아와 저장합니다.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 요청으로 들어온 한글 데이터 깨짐 방지 설정
        ObjectMapper objectMapper = new ObjectMapper(); // JSON 문장을 자바 객체로 변환해 주는 객체 생성

        // HTTP 요청의 스트림(req.getInputStream())을 읽어 JSON 데이터를 자바 Book 클래스 객체로 자동 변환합니다.
        Book book = objectMapper.readValue(req.getInputStream(), Book.class);

        System.out.println("도서 등록 요청 들어옴"); // 터미널 콘솔 출력
        System.out.println(book); // 파싱된 Book 객체를 인텔리제이 터미널 콘솔에 출력

        try {
            bookService.register(book); // 서비스의 register()를 호출해 데이터 중복검사 및 저장 수행
            resp.setContentType("application/json"); // 클라이언트에 보낼 응답 데이터 타입을 JSON으로 지정
            resp.setCharacterEncoding("UTF-8"); // 응답 한글 깨짐 방지
            resp.setStatus(200); // HTTP 성공 상태코드 200 설정
            // {"message": "도서 등록 성공"} JSON 문자열을 만들어 클라이언트(JSP)에 전송합니다.
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", "도서 등록 성공"
            )));
        } catch (DuplicatedException e) { // 만약 도서명 중복 예외가 발생하면
            resp.setContentType("application/json"); // 응답 타입을 JSON으로 지정
            resp.setCharacterEncoding("UTF-8"); // 응답 한글 깨짐 방지
            resp.setStatus(400); // HTTP 클라이언트 에러 상태코드 400 설정
            // {"message": "이미 존재하는 도서명입니다."} JSON 메시지를 클라이언트에 전송합니다.
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", e.getMessage()
            )));
            return; // 메서드 실행 종료
        }
    }
}
*/