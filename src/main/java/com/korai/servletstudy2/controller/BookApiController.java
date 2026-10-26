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
            return;
        }
    }
}
