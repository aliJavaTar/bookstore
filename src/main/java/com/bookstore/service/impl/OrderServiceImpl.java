package com.bookstore.service.impl;

import com.bookstore.dao.OrderDao;
import com.bookstore.entity.Order;
import com.bookstore.service.OrderService;
import com.bookstore.service.base.BaseServiceImpl;

public class OrderServiceImpl extends BaseServiceImpl<Order,Long, OrderDao> implements OrderService {
    public OrderServiceImpl(OrderDao repository) {
        super(repository);
    }
}
