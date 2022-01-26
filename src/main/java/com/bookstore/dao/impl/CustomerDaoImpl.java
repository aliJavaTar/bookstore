package com.bookstore.dao.impl;

import com.bookstore.dao.CustomerDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.Customer;

import javax.persistence.EntityManager;

public class CustomerDaoImpl extends BaseDaoImpl<Customer,Long> implements CustomerDao {
    public CustomerDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
