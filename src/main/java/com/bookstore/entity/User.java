package com.bookstore.entity;

import javax.persistence.*;

@Entity
//@Table(name = User.TABLE_NAME)
public class User {
    //  protected final static String TABLE_NAME ="users";
    private final static String USER_ID = "user_id";
    private final static String EMAIL = "users";
    private final static String FULL_NAME = "users";
    private final static String PASSWORD = "users";
    @Column(name =USER_ID)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;
    @Column(name = EMAIL,nullable = false,unique = true)
    private String email;
    @Column(name = FULL_NAME,nullable = false)
    private String fullName;
    @Column(name = PASSWORD,nullable = false)
    private String password;


    public User() {
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
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
