package com.bookstore.service.impl;

import com.bookstore.dao.CategoryDao;
import com.bookstore.entity.Category;
import com.bookstore.service.CategoryService;
import com.bookstore.service.base.BaseServiceImpl;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.List;

public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryDao> implements CategoryService {
    public CategoryServiceImpl(CategoryDao repository) {
        super(repository);
    }

    @Override
    public Category create(Category category) {

        Category findByName = findByName(category.getName());
        if (findByName != null) {
            throw new NoResultException("Could  not create new category because already exist !");
        } else if (findByName == null){
            return super.create(category);
        }
       return null;
    }

    @Override
    public Category update(Category category) {
        Category findByName = findByName(category.getName());
        if (findByName != null) {
            throw new NonUniqueResultException("Could  not update new category because already exist !");
        } else if (findByName == null){
            return super.update(category);
        }
        return null;
    }

    @Override
    public Category findByName(String name) {
        return repository.findByName(name);
    }
}
