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
    public User update(User user) {
        return super.update(user);
    }

    @Override
    public User findByEmail(String email) {
        String query = "from User u where u.email = :email";
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
    public User findByName(User user) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        Predicate checkUsername = criteriaBuilder.equal(from.get("fullName"), user.getFullName());
        query.select(from).where(checkUsername);
        User userLogin = getEntityManager().createQuery(query).getSingleResult();
        return userLogin;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
