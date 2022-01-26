package com.bookstore.dao.impl;

import com.bookstore.dao.OrderDetailDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.OrderDetail;

import javax.persistence.EntityManager;

public class OrderDetailDaoImpl extends BaseDaoImpl<OrderDetail,Long> implements OrderDetailDao {
    public OrderDetailDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<OrderDetail> getEntityClass() {
        return OrderDetail.class;
    }
}
