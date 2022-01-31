package com.bookstore.entity;

import com.bookstore.entity.base.BaseEntity;
import com.bookstore.entity.profile.Profile;

import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
public class User extends Profile {
    protected final static String TABLE_NAME = "users";

    public User() {
    }

    public User(String email, String fullName, String password) {
        super(email, fullName, password);
    }

    public User(Long id, String email, String fullName, String password) {
        super(id, email, fullName, password);
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
