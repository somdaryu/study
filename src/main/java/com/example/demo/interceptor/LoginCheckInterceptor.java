package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession(false);
        Object id = (session != null) ? session.getAttribute("id") : null;

        System.out.println("요청 메서드: " + request.getMethod());

        if (id == null) {
            // 요청 방식이 POST인 경우 (즉, API 요청)
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                response.setContentType("application/json; charset=UTF-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("{\"error\": \"unauthorized\", \"message\": \"로그인이 필요합니다.\"}");
                return false;
            }

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('로그인이 필요합니다.');");
            out.println("location.href='/member/login';");
            out.println("</script>");
            out.flush();
            return false;
        }

        return true;
    }
}