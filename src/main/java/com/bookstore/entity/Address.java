package com.bookstore.entity;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.bookstore.entity.Address.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Address extends BaseEntity<Long> {
    protected final static String TABLE_NAME = "addresses";
    private final static String COUNTRY = "country";
    private final static String CITY = "city";
    private final static String STREET = "street";
    private final static String ALLEY = "alley";

    @Column(name = COUNTRY, nullable = false)
    private String Country;
    @Column(name = CITY, nullable = false)
    private String city;
    @Column(name = STREET, nullable = false)
    private String street;
    @Column(name = ALLEY, nullable = false)
    private String alley;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }
}
