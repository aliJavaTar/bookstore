package com.bookstore.controller.admin.books;

import com.bookstore.entity.Books;
import com.bookstore.entity.Category;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/edit_book")
public class EditBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        Books bookFind = ApplicationContext.getBookService().findById(id);
        request.setAttribute("book", bookFind);
        request.setAttribute("categoryList", ApplicationContext.getCategoryService().findAll());
        request.getRequestDispatcher("book/book_edit.jsp").forward(request, response);
    }
}
