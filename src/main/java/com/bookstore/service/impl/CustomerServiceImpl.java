package com.bookstore.service.impl;

import com.bookstore.dao.CustomerDao;
import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;
import com.bookstore.service.base.BaseServiceImpl;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerDao> implements CustomerService {
    public CustomerServiceImpl(CustomerDao repository) {
        super(repository);
    }
}
