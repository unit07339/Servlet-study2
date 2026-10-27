package com.korai.servletstudy2.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// GET 요청 시 가입 양식 페이지(register.jsp)로 이동
@WebServlet("/user/register") // 웹 브라우저 주소창에 user/register로 접속했을 때 이 서블릿이 실행되도록 URL을 매핑해줌
public class UserRegisterController extends HttpServlet {

    @Override
    // 주소를 직접 입력해서 들어오는 요청은 HTTP GEt 방식이므로 doGet 메서드 작성
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req,resp);
    } // WEB-INF 폴더 내부에 있는 JSP는 보안상 브라우저에서 직접 URL로 접근 불가능,
    // 서블릿 요청 받아서 /WEB-INF/views/register.jsp 화면으로 요청을 그대로 넘겨주는(forward) 역할을 담당
}
