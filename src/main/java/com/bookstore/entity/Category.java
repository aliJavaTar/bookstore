package com.bookstore.entity;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.*;

import static com.bookstore.entity.Category.TABLE_NAME;

@Entity
@Table(name =TABLE_NAME)
public class Category extends BaseEntity<Long> {
    protected final static String TABLE_NAME = "Categories";
    private final static String NAME = "name";
    @Column(name = NAME)
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name="fk_book_id",referencedColumnName="id",nullable=false,unique=true)
    private Books books;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
