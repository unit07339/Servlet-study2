package com.korai.servletstudy2.controller;

import com.korai.servletstudy2.exception.DuplicatedException;
import com.korai.servletstudy2.model.User;
import com.korai.servletstudy2.service.UserService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/users") // 프론트엔드(register.jsp)의 fetch 요청 URL과 정확히 짝을 이룸
public class UserApiController extends HttpServlet {
    private UserService userService;

    @Override // 서블릿이 생성될 때 1회 호출되어 UserService 싱글톤 객체 인스턴스를 가져와 준비시킴
    public void init(ServletConfig config) throws ServletException {
        userService = UserService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, RuntimeException, IOException {
        req.setCharacterEncoding("UTF-8"); // 요청 들어올때 한글 깨짐 방지
        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리 핵심 객체, JSON <-> Java 객체 간 상호 변환에 사용됨
        User user = objectMapper.readValue(req.getInputStream(), User.class); // 요청 Body의 JSON을 User 객체로 변환
        System.out.println("사용자 등록 요청 들어옴");
        System.out.println(user);
        try { // 회원가입 비즈니스 로직을 구동, 성공 시 통과하고, 중복이 발생하면 아래 catch 블록으로 점프
        userService.register(user);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8"); // 클라이언트(브라우저)에게 응답데이터는 UTF-8로 인코딩된 JSON 데이터라고 알려주는 설정
            resp.setStatus(200); // 성공
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", "사용자 등록 성공" // 자바의 Map 객체를 {"m",~"} 형태의 JSON 문자열로 변환하여 브라우저로 출력(getWriter.println)함
            )));
        } catch (DuplicatedException e) { // 중복 예외 처리 (400 상태 및 에러 메시지 반환)
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(400); // 실패
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", e.getMessage()
            )));
            return;
        }
    }
}
