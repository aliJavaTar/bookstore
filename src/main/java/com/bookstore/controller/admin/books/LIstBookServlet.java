package com.bookstore.controller.admin.books;

import com.bookstore.entity.Books;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/list_books")
public class LIstBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Books> booksList = ApplicationContext.getBookService().findAll();
          request.setAttribute("books",booksList);
          request.getRequestDispatcher("book/book_list.jsp").forward(request,response);
    }

}
