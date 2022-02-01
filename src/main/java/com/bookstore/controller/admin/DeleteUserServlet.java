package com.bookstore.controller.admin;

import com.bookstore.hibernateUtil.appcontext.ApplicationContext;
import com.bookstore.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = ApplicationContext.getUserService();
        long id = Long.parseLong(request.getParameter("id"));
        userService.deleteByID(id);
        userService.findAll(request,response);
    }
}
