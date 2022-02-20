package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.UserDao;
import com.bookstore.entity.Books;
import com.bookstore.entity.Category;
import com.bookstore.entity.User;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoImplTest extends TestCase {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    private static BookDao bookDao;
    private Books books = new Books();

    @BeforeAll
    public static void setUpClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        bookDao = new BookDaoImpl(entityManager);
    }

    @Test
    void create() {
        Category category = new Category();
        category.setId(1l);
        category.setName("java");
        setUpClass();
         books = new Books("java","java Ee","ali","gr",2600,new Date(2l),category);
        bookDao.create(books);
    }

    @Test
    void update() {
        setUpClass();
        books.setId(2l);
        books.setPrice(4000);
        bookDao.update(books);
    }

    @Test
    void listByCategory() {
        setUpClass();
        long categoryId = 1;
        List<Books> booksList = bookDao.listByCategory(categoryId);
        Assert.assertTrue(booksList.size()>0);
        for (Books b :booksList) {
            System.out.println(b);
        }
    }
}