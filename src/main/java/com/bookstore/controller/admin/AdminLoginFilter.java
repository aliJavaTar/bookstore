package com.bookstore.controller.admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {
    public AdminLoginFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpSession session = httpRequest.getSession(false);// create if it doesn't exist
//        if (session != null && !session.isNew()) {
//            chain.doFilter(request, response);
//        } else {
//            ((HttpServletResponse) response).sendRedirect("admin/index.jsp");
//        }
        boolean login = session != null && session.getAttribute("email") != null;
        String loginUrl = httpRequest.getContextPath() + "/admin/login";
        boolean loginRequest = httpRequest.getRequestURI().equals(loginUrl);
        boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
        if (login && (loginRequest || loginPage)) {
            request.getRequestDispatcher("/admin/").forward(request, response);

        }
        if (login || loginRequest) {
            chain.doFilter(request, response);
        } else
            request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
