package com.bookstore.controller.frontend;

import com.bookstore.hibernateUtil.appcontext.ApplicationContext;
import org.hibernate.boot.model.source.internal.hbm.AbstractPluralAssociationElementSourceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1l;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("listCategory", ApplicationContext.getCategoryService().findAll());

        String homePage = "frontend/index.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(homePage);
        requestDispatcher.forward(request,response);
    }
}
