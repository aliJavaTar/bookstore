package com.bookstore.entity;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.*;

import java.util.List;

import static com.bookstore.entity.Category.TABLE_NAME;

@Entity
@Table(name =TABLE_NAME)
public class Category extends BaseEntity<Long> {
    protected final static String TABLE_NAME = "Categories";
    private final static String NAME = "name";
    @Column(name = NAME)
    private String name;


    //
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Books> books;

    //

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

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

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
