package com.bookstore.dao.impl;

import com.bookstore.dao.ReviewDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.Review;

import javax.persistence.EntityManager;

public class ReviewDaoImpl extends BaseDaoImpl<Review,Long> implements ReviewDao {

    public ReviewDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Review> getEntityClass() {
        return Review.class;
    }
}
