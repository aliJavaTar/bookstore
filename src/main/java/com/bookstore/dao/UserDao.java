package com.bookstore.dao;

import com.bookstore.dao.base.BaseDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.User;


public interface UserDao extends BaseDao<User, Long> {

    User findByEmail(String email);

    User findByName(User user);
}
