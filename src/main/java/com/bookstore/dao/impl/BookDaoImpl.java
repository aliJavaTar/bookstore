package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.Books;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookDaoImpl extends BaseDaoImpl<Books, Long> implements BookDao {
    public BookDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public Class<Books> getEntityClass() {
        return Books.class;
    }

    @Override
    public List<Books> listByCategory(long categoryId) {
        getEntityManager().getTransaction().begin();
//        String query = "select u from User u where u.email = :email";
        String query = "select b from Books b join Category c on b.category.id = c.id and c.id = :categoryId";

        List<Books> resultList =  getEntityManager().createQuery(query).
                setParameter("categoryId", categoryId).getResultList();

        getEntityManager().getTransaction().commit();
        return resultList;
    }
}
