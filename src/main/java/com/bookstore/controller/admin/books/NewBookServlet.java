package com.bookstore.controller.admin.books;

import com.bookstore.entity.Category;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/new_book")
public class NewBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showBookNewForm(request, response);
    }

    private void showBookNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = ApplicationContext.getCategoryService().findAll();
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("book/book_form.jsp").forward(request, response);
    }

}
