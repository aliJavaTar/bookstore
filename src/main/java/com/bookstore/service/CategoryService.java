package com.bookstore.service;

import com.bookstore.entity.Category;
import com.bookstore.service.base.BaseService;

public interface CategoryService extends BaseService<Category,Long> {
    Category findByName(String name) ;
}
