package com.bookstore.controller.admin.books;

import com.bookstore.entity.Books;
import com.bookstore.entity.Category;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;


@WebServlet("/admin/create_book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,  // 10 MB
        maxFileSize = 1024 * 1024 * 50,       // 50 MB
        maxRequestSize = 1024 * 1024 * 100)    // 100 MB
public class CreateBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Books books = insertBook(request);
        ApplicationContext.getBookService().create(books);
        books.setImage(getImage(request.getPart("image")));
//        byte[] image = books.getImage();

    }

    private Books insertBook(HttpServletRequest request) throws ServletException {
        Books books = new Books();
        books.setTitle(getStringValue("title", request));
        books.setAuthor(getStringValue("author", request));
        books.setDescription(getStringValue("description", request));
        books.setPrice(getDoubleValue("price", request));
        books.setPublish_date(getPublishDate("publish_date", request));
        Category category = ApplicationContext.getCategoryService().findById(getLongValue("category", request));
        books.setIsbn(getStringValue("isbn", request));
        books.setCategory(category);
        return books;
    }

    private byte[] getImage(Part imagePart) throws IOException {

        return ApplicationContext.getBookService().readImage(imagePart);
    }


    private String getStringValue(String name, HttpServletRequest request) {
        return request.getParameter(name);
    }


    private Long getLongValue(String name, HttpServletRequest request) {
        return Long.parseLong(request.getParameter(name));
    }

    private Double getDoubleValue(String name, HttpServletRequest request) {
        return Double.parseDouble(request.getParameter(name));
    }


    private Date getPublishDate(String name, HttpServletRequest request) throws ServletException {
        java.sql.Date sqlDate;
        String publish_date = request.getParameter(name);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date publishDate;
        try {
            publishDate = simpleDateFormat.parse(publish_date);
            sqlDate = new java.sql.Date(publishDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ServletException("Error parse date");
        }
        return sqlDate;
    }
}
