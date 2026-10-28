package com.korai.servletstudy2.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/api/*")
public class Utf8EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("1");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8"); // req,resp 둘다 전처리 (순서 잘 지켜야됨)
        chain.doFilter(request, response); // 이거 호출해야지만 서블릿에 있는 doPost, doGet이 작동
        System.out.println("3");
    }
}
