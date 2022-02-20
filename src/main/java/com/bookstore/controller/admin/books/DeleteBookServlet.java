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

import static com.bookstore.hibernateUtil.appcontext.ApplicationContext.getBookService;

@WebServlet("/admin/delete_book")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        getBookService().deleteByID(Long.parseLong((id)));
        getBookService().deleteImage("C:\\Users\\Lion\\Desktop\\BookStorWebsit\\src\\main\\webapp\\image\\" + id + ".jpg");
//        response.sendRedirect("http://localhost:8080/BookStorWebsit_war_exploded/admin/list_books");
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Books> allBooks = ApplicationContext.getBookService().findAll();
        request.setAttribute("books", allBooks);
        request.getRequestDispatcher("book/book_list.jsp").forward(request, response);
    }
}
