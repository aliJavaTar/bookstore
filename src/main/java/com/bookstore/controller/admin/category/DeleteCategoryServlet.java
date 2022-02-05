package com.bookstore.controller.admin.category;

import com.bookstore.hibernateUtil.appcontext.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long id = Long.parseLong(request.getParameter("id"));
            ApplicationContext.getCategoryService().deleteByID(id);
            request.setAttribute("listCategory", ApplicationContext.getCategoryService().findAll());
            request.setAttribute("message", "delete Category done! ");
            String listPage = "list_category.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
            dispatcher.forward(request, response);
        } catch (Exception exception) {
            exception.printStackTrace();
            request.setAttribute("message", exception.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
            dispatcher.forward(request, response);
        }


    }
}
//  try {
//          String name = request.getParameter("name");
//          long id = Long.parseLong(request.getParameter("id"));
//          ApplicationContext.getCategoryService().update(new Category(id, name));
////        ApplicationContext.getCategoryService().findAll();
//          request.setAttribute("listCategory", ApplicationContext.getCategoryService().findAll());
//          request.setAttribute("message", "update Category done! ");
//          String listPage = "list_category.jsp";
//          RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
//          dispatcher.forward(request, response);
//
//          }
//          catch (NonUniqueResultException exception){
//          exception.printStackTrace();
//          request.setAttribute("message", exception.getMessage());
//          RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
//          dispatcher.forward(request, response);
//          }