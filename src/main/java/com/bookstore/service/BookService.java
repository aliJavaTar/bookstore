package com.bookstore.service;

import com.bookstore.entity.Books;
import com.bookstore.service.base.BaseService;

import javax.servlet.http.Part;
import java.io.IOException;

public interface BookService extends BaseService<Books,Long> {
    boolean deleteImage(String image_path);
     byte[] readImage(Part image) throws IOException;
}
