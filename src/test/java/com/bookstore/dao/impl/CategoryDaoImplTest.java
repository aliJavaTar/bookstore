package com.bookstore.dao.impl;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.UserDao;
import com.bookstore.entity.Category;
import com.bookstore.entity.User;
import com.bookstore.hibernateUtil.appcontext.ApplicationContext;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryDaoImplTest extends TestCase {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    private static CategoryDao categoryDao;
    private Category category = new Category();

    @BeforeAll
    public static void setUpClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        categoryDao = ApplicationContext.getCategoryDao();
    }

    @Test
    void findByName() {
        Category health = categoryDao.findByName("Health");
        System.out.println(health);
        assertNotNull(health);
    }

    @Test
    void testFindByNameNotFound() {
        assertNotNull(categoryDao.findByName("Health3"));
    }
}