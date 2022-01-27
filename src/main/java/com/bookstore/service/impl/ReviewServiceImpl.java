package com.bookstore.service.impl;

import com.bookstore.dao.ReviewDao;
import com.bookstore.entity.Review;
import com.bookstore.service.ReviewService;
import com.bookstore.service.base.BaseServiceImpl;

public class ReviewServiceImpl extends BaseServiceImpl<Review,Long, ReviewDao> implements ReviewService {
    public ReviewServiceImpl(ReviewDao repository) {
        super(repository);
    }
}
