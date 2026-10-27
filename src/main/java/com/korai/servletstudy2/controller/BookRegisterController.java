package com.korai.servletstudy2.controller;


// 5. 도서 등록 폼 JSP로 이동시키는 컨트롤러


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/register")
public class BookRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/book-register.jsp").forward(req, resp);
    }
}

// 6. book-register,jsp로 가기 -> 도서명(bookName)과 가격(price)을 입력받아 API 서브릿으로 전송하는 UI화면
// 7. BookApiController




/*
package com.korai.servletstudy2.controller; // 패키지 위치 지정

import javax.servlet.ServletException; // 서블릿 관련 예외 가져오기
import javax.servlet.annotation.WebServlet; // 서블릿 매핑 어노테이션 가져오기
import javax.servlet.http.HttpServlet; // 서블릿 기본 상속 클래스 가져오기
import javax.servlet.http.HttpServletRequest; // HTTP 요청 객체 가져오기
import javax.servlet.http.HttpServletResponse; // HTTP 응답 객체 가져오기
import java.io.IOException; // 입출력 예외 가져오기

@WebServlet("/book/register") // 브라우저가 localhost:8080/book/register 로 접속하면 이 서블릿이 작동합니다.
public class BookRegisterController extends HttpServlet { // HttpServlet을 상속받아 서블릿 역할을 수행합니다.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // WEB-INF/views/book-register.jsp 화면으로 요청과 응답 객체를 포워딩(전달)합니다.
        req.getRequestDispatcher("/WEB-INF/views/book-register.jsp").forward(req, resp);
    }
}
*/