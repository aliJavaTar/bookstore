package com.bookstore.controller.admin;

import com.bookstore.entity.User;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/user_list")
public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl(ApplicationContext.getUserDao());
        userService.findAll(request,response);
//        List<User> userList = userService.findAll();
//
//        request.setAttribute("userList", userList);
//        String listPage = "user_list.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
//        dispatcher.forward(request, response);
    }

}
