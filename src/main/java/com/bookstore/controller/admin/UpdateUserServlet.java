package com.bookstore.controller.admin;

import com.bookstore.entity.User;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@WebServlet("/admin/update_user")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("omadam");
        UserService userService = ApplicationContext.getUserService();
        //    UserService userService = new UserServiceImpl(ApplicationContext.getUserDao());
        Long id = Long.parseLong(request.getParameter("id"));
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email);
        User user = new User(id, fullName, email, password);
//        User user = (User) request.getAttribute("user");
//        System.out.println("user before edit : " + user);
        User update = userService.update(user);
//        System.out.println("user after edit : " + update);
        System.out.println(update);
        userService.findAll(request, response);
    }
}
