package com.bookstore.service.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.User;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;
import com.bookstore.service.UserService;
import com.bookstore.service.base.BaseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserDao> implements UserService {
    public UserServiceImpl(UserDao repository) {
        super(repository);
    }

    private final static UserService userService = new UserServiceImpl(ApplicationContext.getUserDao());
    private static int size = userService.findAll().size();


    @Override
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = super.findAll();
        request.setAttribute("userList", userList);
        System.out.println(size);
        System.out.println("-------------------------");
        System.out.println(userList.size());
        if (size < userList.size()) {
            request.setAttribute("message", "New User Created Successfully");
            size++;
        }
        //  response.getWriter().println("New User Created Successfully");

        String listPage = "user_list.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
        dispatcher.forward(request, response);
    }

    @Override
    public void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        // find by email error
        User existUser = findByEmail(email);
        if (existUser != null) {
          String message = "Could Not Create User , A user whit email "+email+" Already exist";
          request.setAttribute("message",message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request,response);
        }
        else if (existUser==null)
        {
            System.out.println(existUser);
            userService.create(new User(email, fullName, password));
            userService.findAll(request,response);
        }
//        if (user != null)
//            request.setAttribute("massage", "New User Created Successfully");
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
