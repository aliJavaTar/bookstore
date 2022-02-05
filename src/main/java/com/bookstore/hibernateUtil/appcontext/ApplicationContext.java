package com.bookstore.hibernateUtil.appcontext;

import com.bookstore.dao.*;
import com.bookstore.dao.impl.*;
import com.bookstore.hibernateUtil.Jpa;
import com.bookstore.service.*;
import com.bookstore.service.impl.*;


import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final UserDao userDao;
    private static final AddressDao addressDao;
    private static final BookDao bookDao;
    private static final CategoryDao categoryDao;
    private static final CustomerDao customerDao;
    private static final OrderDao orderDao;
    private static final OrderDetailDao orderDetailDao;
    private static final ReviewDao reviewDao;
    ///////////////////////////////
    private static final CategoryService categoryService;
    private static final UserService userService;
    private static final AddressService addressService;
    private static final BookService bookService;
    private static final CustomerService customerService;
    private static final OrderService orderService;
    private static final OrderDetailService orderDetailService;
    private static final ReviewService reviewService;

    static {
        EntityManager entityManager = Jpa.getEntityManagerFactory().createEntityManager();
        userDao = new UserDaoImpl(entityManager);
        addressDao = new AddressDaoImpl(entityManager);
        customerDao = new CustomerDaoImpl(entityManager);
        orderDao = new OrderDaoImpl(entityManager);
        orderDetailDao = new OrderDetailDaoImpl(entityManager);
        reviewDao = new ReviewDaoImpl(entityManager);
        bookDao = new BookDaoImpl(entityManager);
        categoryDao = new CategoryDaoImpl(entityManager);
        /////////////////////////////////////
        categoryService=new CategoryServiceImpl(categoryDao);
        userService = new UserServiceImpl(userDao);
        addressService = new AddressServiceImpl(addressDao);
        customerService = new CustomerServiceImpl(customerDao);
        bookService = new BookServiceImpl(bookDao);
        orderService = new OrderServiceImpl(orderDao);
        orderDetailService = new OrderDetailServiceImpl(orderDetailDao);
        reviewService = new ReviewServiceImpl(reviewDao);
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static AddressDao getAddressDao() {
        return addressDao;
    }

    public static BookDao getBookDao() {
        return bookDao;
    }

    public static CustomerDao getCustomerDao() {
        return customerDao;
    }

    public static OrderDao getOrderDao() {
        return orderDao;
    }

    public static OrderDetailDao getOrderDetailDao() {
        return orderDetailDao;
    }

    public static ReviewDao getReviewDao() {
        return reviewDao;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static AddressService getAddressService() {
        return addressService;
    }

    public static BookService getBookService() {
        return bookService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static OrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    public static OrderService getOrderService() {
        return orderService;
    }

    public static ReviewService getReviewService() {
        return reviewService;
    }

    public static CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public static CategoryService getCategoryService() {
        return categoryService;
    }
}
