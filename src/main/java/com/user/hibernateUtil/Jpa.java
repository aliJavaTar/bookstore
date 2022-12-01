package com.bookstore.hibernateUtil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpa {
    private static final EntityManagerFactory entityManagerFactory ;
    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("BookStoreWebsite");
    }
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
