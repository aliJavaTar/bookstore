package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.UserDao;
import com.bookstore.entity.Books;
import com.bookstore.entity.Category;
import com.bookstore.entity.Review;
import com.bookstore.entity.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Timestamp;

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
        category.setName("Java Core");
        category.setId(3l);
        setUpClass();
        bookDao.create(new Books("java","Java Ee","ali","ye ye"
                ,"https://www.google.com/url?sa=i&url=https%3A%2F%2Fdata.europa.eu%2Ffi%2Fnews%2Fedp-book-club&psig=AOvVaw1308KvKs2-rnem-jkPBYSv&ust=1644924390948000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCLD2tMSL__UCFQAAAAAdAAAAABAD",
                2000,new Timestamp(1999l),category));
    }

    @Test
    void update() {
        setUpClass();
        Category category = new Category();
        category.setName("Java Core");
        category.setId(3l);
        books.setId(1l);

    }
}