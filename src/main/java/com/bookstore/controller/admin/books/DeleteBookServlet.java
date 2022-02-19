package com.bookstore.controller.admin.books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.bookstore.hibernateUtil.appcontext.ApplicationContext.getBookService;

@WebServlet("/admin/delete_book")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("delete book !! ");
        String id = request.getParameter("id");
        getBookService().deleteByID(Long.parseLong((id)));

        getBookService().deleteImage("C:\\Users\\Lion\\Desktop\\BookStorWebsit\\src\\main\\webapp\\image\\"+id+".jpg");


//        request.getRequestDispatcher("book_list").forward(request, response);
        response.sendRedirect("http://localhost:8080/BookStorWebsit_war_exploded/admin/list_books");

    }
}
