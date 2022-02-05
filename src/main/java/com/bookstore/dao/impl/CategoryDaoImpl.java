package com.bookstore.dao.impl;

import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.Category;
import com.bookstore.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CategoryDaoImpl extends BaseDaoImpl<Category, Long> implements CategoryDao {
    public CategoryDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }


    public Category findByName(String name) {
        String query = "select c from Category c where c.name =:name";
        Category category = null;
        getEntityManager().getTransaction().begin();
        try {
//           getEntityManager().getTransaction().begin();
            category = (Category) getEntityManager().createQuery(query)
                    .setParameter("name", name).getSingleResult();
            getEntityManager().getTransaction().commit();
        } catch (NoResultException nre) {
            nre.printStackTrace();
            getEntityManager().getTransaction().commit();
        }
        if (category != null)
            return category;
        else return null;
    }

    @Override
    public Class<Category> getEntityClass() {
        return Category.class;
    }
}
