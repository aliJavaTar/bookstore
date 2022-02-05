package com.bookstore.dao;

import com.bookstore.dao.base.BaseDao;
import com.bookstore.entity.Category;
import com.bookstore.entity.User;

public interface CategoryDao extends BaseDao<Category,Long> {
//    Category findByName(Category category);
    Category findByName(String name);
}
