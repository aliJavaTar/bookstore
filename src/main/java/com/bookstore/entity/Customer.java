package com.bookstore.entity;

import com.bookstore.entity.profile.Profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.sql.Date;
import java.sql.Timestamp;

import static com.bookstore.entity.Customer.TABLE_NAME;


@Entity
@Table(name = TABLE_NAME)
public class Customer extends Profile {
    protected final static String TABLE_NAME = "customers";
    private final static String PHONE_NUMBER = "phone_number";
    private final static String ZIP_CODE = "zip_code";
    private final static String REGISTER_DATE = "register_date";
    @Column(name = PHONE_NUMBER, nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = ZIP_CODE, nullable = false)
    private String zipCode;
    @Column(name = REGISTER_DATE, nullable = false)
    private Timestamp registerDate;
    @OneToOne
    private Address address;


    public Customer() {
    }

    public Customer(String email, String fullName, String password, String phoneNumber, String zipCode, Timestamp registerDate) {
        super(email, fullName, password);
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.registerDate = registerDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
