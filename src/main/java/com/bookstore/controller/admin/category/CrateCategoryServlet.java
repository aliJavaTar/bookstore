package com.bookstore.controller.admin.category;

import com.bookstore.entity.Category;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/create_category")
public class CrateCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name");

        try {
            ApplicationContext.getCategoryService().create(new Category(name));

            RequestDispatcher dispatcher = request.getRequestDispatcher("list_category.jsp");
            dispatcher.forward(request, response);
        } catch (Exception exception) {
            exception.printStackTrace();
            request.setAttribute("message", exception.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);
        }
//        String path ="";
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
//        requestDispatcher.forward(request,response);
    }
}
