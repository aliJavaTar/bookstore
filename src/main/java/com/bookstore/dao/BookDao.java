package com.bookstore.dao;

import com.bookstore.dao.base.BaseDao;
import com.bookstore.entity.Books;

import java.util.List;


public interface BookDao extends BaseDao<Books,Long> {
    List<Books> listByCategory(long categoryId);
}
