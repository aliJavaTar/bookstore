package com.bookstore.entity.profile;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Profile extends BaseEntity<Long> {
    private final static String EMAIL = "email";
    private final static String FULL_NAME = "full_name";
    private final static String PASSWORD = "password";


    @Column(name = EMAIL,nullable = false,unique = true)
    private String email;

    @Column(name = FULL_NAME,nullable = false)
    private String fullName;

    @Column(name = PASSWORD,nullable = false)
    private String password;


    public Profile() {
    }

    public Profile(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
