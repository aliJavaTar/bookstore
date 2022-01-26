package com.bookstore.dao.impl;

import com.bookstore.dao.OrderDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.Order;

import javax.persistence.EntityManager;

public class OrderDaoImpl extends BaseDaoImpl<Order,Long> implements OrderDao {
    public OrderDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }
}
