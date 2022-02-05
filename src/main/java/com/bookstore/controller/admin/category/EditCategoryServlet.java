package com.bookstore.controller.admin.category;

import com.bookstore.entity.Category;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;
import org.hibernate.boot.model.source.internal.hbm.AbstractPluralAssociationElementSourceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit_category")
public class EditCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/admin/edit_category");
        long id = Long.parseLong(request.getParameter("id"));
        Category category = ApplicationContext.getCategoryService().findById(id);
        request.setAttribute("category",category);
        String updatePage = "edit_category.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(updatePage);
        dispatcher.forward(request, response);
    }
}
