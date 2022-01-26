package com.bookstore.dao.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.User;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoImplTest extends TestCase {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    private static UserDao userDao;

    @BeforeClass
    public static void setUpClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDao = new UserDaoImpl(entityManager);
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setFullName("aliErfagh");
        user.setEmail("aliJavaBoy@gmail.com");
        user.setPassword("ali77");
        userDao.create(user);
        assertTrue(user.getId() > 0);
    }

    @Test
    public void testCreateUserFieldsNotSet() {
        User user = new User();
        user.setPassword("345");
        user.setEmail("asdf@gamil.com");
        userDao.create(user);
        assertTrue(user.getId() > 0);
    }
    @AfterClass
    public static  void tearDownClass()
    {
        entityManager.close();
        entityManagerFactory.close();
    }
}