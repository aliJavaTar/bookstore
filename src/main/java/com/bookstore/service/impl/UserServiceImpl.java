package com.bookstore.service.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.User;
import com.bookstore.service.UserService;
import com.bookstore.service.base.BaseServiceImpl;

public class UserServiceImpl extends BaseServiceImpl<User,Long, UserDao> implements UserService {
    public UserServiceImpl(UserDao repository) {
        super(repository);
    }
}
