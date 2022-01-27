package com.bookstore.hibernateUtil.appcontext;

import com.bookstore.dao.*;
import com.bookstore.dao.impl.*;
import com.bookstore.hibernateUtil.Jpa;


import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final UserDao userDao;
    private static final AddressDao addressDao;
    private static final BookDao bookDao;
    private static final CustomerDao customerDao;
    private static final OrderDao orderDao;
    private static final OrderDetailDao orderDetailDao;
    private static final ReviewDao reviewDao;

    static {
        EntityManager entityManager = Jpa.getEntityManagerFactory().createEntityManager();
        userDao = new UserDaoImpl(entityManager);
        addressDao = new AddressDaoImpl(entityManager);
        customerDao = new CustomerDaoImpl(entityManager);
        orderDao = new OrderDaoImpl(entityManager);
        orderDetailDao = new OrderDetailDaoImpl(entityManager);
        reviewDao = new ReviewDaoImpl(entityManager);
        bookDao = new BookDaoImpl(entityManager);
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
}
