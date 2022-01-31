package com.bookstore.service;

import com.bookstore.entity.User;
import com.bookstore.service.base.BaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService extends BaseService<User, Long> {

    void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    User findByEmail(String email);

    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;


    //void editUser(HttpServletRequest request, HttpServletResponse response);
}
