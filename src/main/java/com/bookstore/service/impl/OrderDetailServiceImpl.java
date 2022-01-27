package com.bookstore.service.impl;

import com.bookstore.dao.OrderDetailDao;
import com.bookstore.entity.OrderDetail;
import com.bookstore.service.base.BaseServiceImpl;

public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, Long, OrderDetailDao> {

    public OrderDetailServiceImpl(OrderDetailDao repository) {
        super(repository);
    }
}
