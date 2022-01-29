package com.bookstore.dao.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.User;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

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

    @Test
    public void testCreate() {
        setUpClass();
        user.setFullName("hasan");
        user.setEmail("hasan@gmail.com");
        user.setPassword("hasan007");
        userDao.create(user);
        assertTrue(user.getId() > 0);
    }

    @Test
    public void testUpdate() {
        setUpClass();
        user.setId(19l);
        user.setFullName("java java");
        user.setEmail("jafaar@gmail.com");
        user.setPassword("jdsaf435453453543345");
        User update = userDao.update(user);
        String expected = "java java";
        String actual = update.getFullName();
        assertEquals(expected, actual);
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
        if (userFindById != null)
            System.out.println(userFindById);
        assertNotNull(userFindById);
    }

    @Test
    public void testGetUserNotFound() {
        setUpClass();
        Long userId = 99l;
        User userFind = userDao.getById(userId);
        assertNotNull(userFind);

    }

    @Test
    public void testDelete() {
        setUpClass();
        user.setId(18L);
        user.setFullName("mohserErfagh");
        user.setPassword("m4645");
        user.setEmail("dgfEh@gmail.com");
        boolean delete = userDao.delete(user);
        if (delete)
            System.out.println("done");
        else System.out.println("not found");

    }

    @Test
    public void testDeleteById() {
        setUpClass();
        Long id = 19l;
        userDao.deleteById(id);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDeleteNonExitUsers() {
        setUpClass();
        long id = 5000l;
        userDao.deleteById(id);
    }

    @Test
    public void testFindAll() {
        setUpClass();
        List<User> userList = userDao.findAll();
        assertTrue(userList.size() > 0);
    }
    @Test
    public void testFindByEmail() {
//        user.setId(16l);
//        user.setFullName("mohserErfagh");
//        user.setEmail("Erfagh@gmail.com");
//       user.setPassword("mohserErfagh54645");
        setUpClass();
        User byEmail = userDao.findByEmail("Erfagh@gmail.com");
        System.out.println(byEmail.toString());
        assertNotNull(byEmail);
//        assertEquals(user,byEmail);
    }
}