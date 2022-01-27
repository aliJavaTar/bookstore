package com.bookstore.service.impl;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;
import com.bookstore.service.CategoryService;
import com.bookstore.service.base.BaseServiceImpl;

public class CategoryServiceImpl extends BaseServiceImpl<Category,Long, CategoryDao> implements CategoryService {
    public CategoryServiceImpl(CategoryDao repository) {
        super(repository);
    }
}
