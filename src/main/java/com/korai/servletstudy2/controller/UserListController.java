package com.korai.servletstudy2.controller;

import com.korai.servletstudy2.model.User;
import com.korai.servletstudy2.repository.UserRepository;
import com.korai.servletstudy2.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 저장소의 전체 회원 목록을 조회하여 user-list.jsp로 전달
@WebServlet("/user/list") // 회원 목록을 조회를 위한 화면 접근 URL
public class UserListController extends HttpServlet {

    private UserService userService;

    @Override // 서버가 실행되거나 이 서블릿이 최초 등록될 때, 화면을 테스트해 볼 수 있도록 더미 회원 데이터 2명을 기본으로 추가 등록해 두는 목적으로 작성
    public void init(ServletConfig config) throws ServletException { // 이 클래스가 생성될 때 딱 한번 호출
        // 초기 테스트용 기본 데이터 세팅
        userService = UserService.getInstance();
        userService.register(new User(0, "user1", "1234", "김준일"));
        userService.register(new User(0, "user2", "5678", "김준이"));
    }

    @Override //ctrl O
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 서비스로부터 받아온 전체 회원 명단(List<User>)을 request 보관함에 "userList"라는 이름의 Key로 보관, 이렇게 담아두어야 다음 화면인JSP에서 꺼내어 사용할 수 있음
        req.setAttribute("userList", userService.getUserAll());
        // userList 데이터가 들어있는 req 객체를 들고 /WEB-INF/views/user-list.jsp로 포워딩하여 화면을 만들어 출력하도록 이동
        req.getRequestDispatcher("/WEB-INF/views/user-list.jsp").forward(req, resp); // forward 넘어가는 거
    }
}
