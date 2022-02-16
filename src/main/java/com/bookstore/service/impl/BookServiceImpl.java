package com.bookstore.service.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Books;
import com.bookstore.service.BookService;
import com.bookstore.service.base.BaseServiceImpl;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

public class BookServiceImpl extends BaseServiceImpl<Books,Long, BookDao> implements BookService {
    public BookServiceImpl(BookDao repository) {
        super(repository);
    }

     public boolean deleteImage(String image_path){
        try{
            System.out.println(image_path);
            String canonicalPath = new File(image_path).getAbsolutePath();
            System.out.println(canonicalPath);
            File f = new File(canonicalPath);
            if (f.exists()){
                 System.out.println(f.exists());
                return f.delete();
             }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
