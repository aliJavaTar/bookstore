package com.bookstore.dao.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.User;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class UserDaoImplTest extends TestCase {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;
    private static UserDao userDao;
    private User user = new User();

    @Before
    public static void setUpClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDao = new UserDaoImpl(entityManager);
    }

//    @Test
//    public void testCreate() {
//        setUpClass();
//        user.setFullName("jafaar");
//        user.setEmail("jafaar@gmail.com");
//        user.setPassword("jafaar45");
//        userDao.create(user);
//        assertTrue(user.getId() > 0);
//    }

    @Test
    public void testUpdate() {
        setUpClass();
        user.setId(19l);
        user.setFullName("java java");
        user.setEmail("jafaar@gmail.com");
        user.setPassword("jdsaf435453453543345");
        User update = userDao.update(user);
        String expected ="java java";
        String actual = update.getFullName();
        assertEquals(expected,actual);
        //  assertTrue(user.getId() > 0);
    }

    @Test(expected = PersistenceException.class)
    public void testCreateUserFieldsNotSet() {
        User user = new User();
        user.setPassword("345");
        user.setEmail("asdf@gamil.com");
        userDao.update(user);
        assertTrue(user.getId() > 0);
    }

    @AfterClass
    public static void tearDownClass() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void testGetById() {
        setUpClass();
        User userFindById = userDao.getById(1l);
        System.out.println(userFindById);
    }
}