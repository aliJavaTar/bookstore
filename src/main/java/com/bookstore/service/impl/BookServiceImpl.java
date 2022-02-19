package com.bookstore.service.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Books;
import com.bookstore.service.BookService;
import com.bookstore.service.base.BaseServiceImpl;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BookServiceImpl extends BaseServiceImpl<Books, Long, BookDao> implements BookService {
    public BookServiceImpl(BookDao repository) {
        super(repository);
    }

    public boolean deleteImage(String image_path) {
        try {
            String absolutePath = new File(image_path).getAbsolutePath();
            File f = new File(absolutePath);
            if (f.exists())
                return f.delete();
            else System.out.println(f.exists());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public byte[] readImage(Part image) throws IOException {
        byte[] imageByte ;
        if (image != null&& image.getSize() > 0)
        {
            long size = image.getSize();
            imageByte = new byte[(int) size];
            InputStream inputStream = image.getInputStream();
            inputStream.read(imageByte);
            inputStream.close();
            return imageByte;
        } else throw new IOException("no image");
    }

}
