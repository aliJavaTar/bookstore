package com.bookstore.entity;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Timestamp;

import static com.bookstore.entity.Review.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Review extends BaseEntity<Long> {
    protected final static String TABLE_NAME = "reviews";
    private final static String RATING = "rating";
    private final static String HEADLINE = "headline";
    private final static String COMMENT = "comment";
    private final static String REVIEW_TIME = "review_time";
    @Column(name = RATING, nullable = false)
    private String rating;
    @Column(name = HEADLINE)
    private String headline;
    @Column(name = COMMENT)
    private String comment;
    @Column(name = REVIEW_TIME)
    private Timestamp review_time;

    public Review() {
    }

    public Review(String rating, String headline, String comment, Timestamp review_time) {
        this.rating = rating;
        this.headline = headline;
        this.comment = comment;
        this.review_time = review_time;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getReview_time() {
        return review_time;
    }

    public void setReview_time(Timestamp review_time) {
        this.review_time = review_time;
    }
}
