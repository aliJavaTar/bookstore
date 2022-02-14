package com.bookstore.service.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Books;
import com.bookstore.service.BookService;
import com.bookstore.service.base.BaseServiceImpl;

import java.sql.Timestamp;
import java.util.Date;

public class BookServiceImpl extends BaseServiceImpl<Books,Long, BookDao> implements BookService {
    public BookServiceImpl(BookDao repository) {
        super(repository);
    }


}
