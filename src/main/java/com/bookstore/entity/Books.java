package com.bookstore.entity;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

import static com.bookstore.entity.Books.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Books extends BaseEntity<Long> {

    protected final static String TABLE_NAME = "books";
    private final static String TITLE = "title";
    private final static String DESCRIPTION = "description";
    private final static String AUTHOR = "author";
    private final static String ISBN = "isbn";
    private final static String IMAGE = "image";
    private final static String PRICE = "price";
    private final static String PUBLISH_DATE = "publish_date";
    private final static String UPDATE_AT = "update_at";

    @Column(name = TITLE, nullable = false)
    private String title;
    @Column(name = DESCRIPTION, nullable = false)
    private String description;
    @Column(name = AUTHOR, nullable = false)
    private String author;
    @Column(name = ISBN, nullable = false,columnDefinition = "varchar(30)")
    private String isbn;
    @Column(name = IMAGE, nullable = false)
    private String image;
    @Column(name = PRICE, nullable = false)
    private double price;
    @Column(name = PUBLISH_DATE, nullable = false)
    private Timestamp publish_date;
    @Column(name = UPDATE_AT, nullable = false)
    private Timestamp update_at;
//

    public Books() {
    }

    public Books(String title, String description, String author, String isbn, String image, double price, Timestamp publish_date, Timestamp update_at, Category category, List<Review> reviews, List<OrderDetail> orderDetails) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.image = image;
        this.price = price;
        this.publish_date = publish_date;
        this.update_at = update_at;
        this.category = category;
        this.reviews = reviews;
        this.orderDetails = orderDetails;
    }

    public Books(Long id, String title, String description, String author, String isbn, String image, double price, Timestamp publish_date, Timestamp update_at, Category category, List<Review> reviews, List<OrderDetail> orderDetails) {
        super(id);
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.image = image;
        this.price = price;
        this.publish_date = publish_date;
        this.update_at = update_at;
        this.category = category;
        this.reviews = reviews;
        this.orderDetails = orderDetails;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
//
    @OneToMany(mappedBy = "books",cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "books",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Timestamp publish_date) {
        this.publish_date = publish_date;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
