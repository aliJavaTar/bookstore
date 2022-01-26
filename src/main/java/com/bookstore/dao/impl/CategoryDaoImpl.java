package com.bookstore.dao.impl;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.Category;

import javax.persistence.EntityManager;

public class CategoryDaoImpl extends BaseDaoImpl<Category,Long> implements CategoryDao {
    public CategoryDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Category> getEntityClass() {
        return Category.class;
    }
}
