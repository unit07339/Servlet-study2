package com.korai.servletstudy2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 순서 바꾸려면 web.xml에서 직접 타이핑
//@WebFilter("/api/*")
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("전처리");
        System.out.println("11");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String method = req.getMethod(); // 이 코드 사용하려면 위 코드처럼 다운캐스팅 해야함
        System.out.println(method);

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");



        if ("OPTIONS".equals(method)) {
            resp.setStatus(200);
            return; // doFilter로 넘어가지 않게 return해야함
        }


        chain.doFilter(request,response); // doFilter를 기준으로 전에 실행되는 거 "전처리"
        System.out.println("22");
        System.out.println("후처리");
    }
}
