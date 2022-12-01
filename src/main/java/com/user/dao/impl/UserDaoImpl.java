package com.bookstore.dao.impl;

import com.bookstore.dao.UserDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {
    public UserDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public User findByEmail(String email) {
        String query = "select u from User u where u.email = :email";
        User user = null;
        getEntityManager().getTransaction().begin();
        try {
//           getEntityManager().getTransaction().begin();
            user = (User) getEntityManager().createQuery(query)
                    .setParameter("email", email).getSingleResult();

            getEntityManager().getTransaction().commit();
        } catch (NoResultException nre) {
            nre.printStackTrace();
            getEntityManager().getTransaction().commit();
        }
        if (user != null)
            return user;
        else return null;
    }



    @Override
    public boolean checkLogin(String email, String password) {
        getEntityManager().getTransaction().begin();
        String query = "select u from User u where u.email = :email AND u.password=:password";
        Query qu = getEntityManager().createQuery(query);
        qu.setParameter("email", email);
        qu.setParameter("password", password);
        List resultList = qu.getResultList();
        getEntityManager().getTransaction().commit();
        if (resultList.size() > 0)
            return true;
        else return false;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
