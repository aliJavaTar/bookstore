package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.Books;

import javax.persistence.EntityManager;

public class BookDaoImpl extends BaseDaoImpl<Books, Long> implements BookDao {
    public BookDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }



    @Override
    public Class<Books> getEntityClass() {
        return Books.class;
    }
}
