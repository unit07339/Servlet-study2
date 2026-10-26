package com.korai.servletstudy2.controller;


// 5. 도서 등록 폼 JSP로 이동시키는 컨트롤러
// 6. book-register,jsp로 가기 -> 도서명(bookName)과 가격(price)을 입력받아 API 서브릿으로 전송하는 UI화면

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
