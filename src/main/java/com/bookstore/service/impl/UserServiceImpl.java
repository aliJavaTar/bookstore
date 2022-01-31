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
import java.util.NoSuchElementException;

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
            String message = "Could Not Create User , A user whit email " + email + " Already exist";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);
        } else if (existUser == null) {
//            System.out.println(existUser);
            userService.create(new User(email, fullName, password));
            userService.findAll(request, response);
        }
//        if (user != null)
//            request.setAttribute("massage", "New User Created Successfully");
    }

    @Override
    public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("request.getParameter(id) : " + request.getParameter("id"));
        long id = Long.parseLong(request.getParameter("id"));

        User user = userService.findById(id);
        System.out.println("find User By id : "+ user);
        request.setAttribute("user", user);
        String updatePage = "edit_user.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(updatePage);
        dispatcher.forward(request, response);
    }


    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hi update im coming ............................................");

////        System.out.println( "getAttribute" +request.getAttribute("user"));
//        Long id =Long.parseLong(request.getParameter("id"));
//        String fullName = request.getParameter("fullName");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        System.out.println("update(HttpServletRequest request, HttpServletResponse response)");
//        System.out.println("id : "+ id);
//        System.out.println("fullName : "+ fullName);
//        System.out.println("email : "+ email);
//        System.out.println("password : "+ password);


//
//
//        User user = new User(id,fullName,email,password);
////        User user = (User) request.getAttribute("user");
////        System.out.println("user before edit : " + user);
//        User update = userService.update(user);
////        System.out.println("user after edit : " + update);
//        userService.findAll(request, response);

    }

}
