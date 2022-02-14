package com.bookstore.dao.base;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class BaseDaoImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseDao<E, ID> {

    protected final EntityManager entityManager;

    public BaseDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public abstract Class<E> getEntityClass();

    @Override
    public E create(E e) {
        getEntityManager().getTransaction().begin();
        if (e.getId() == null)
            getEntityManager().persist(e);
        else getEntityManager().merge(e);
        getEntityManager().getTransaction().commit();
        return e;
    }

    @Override
    public E update(E entity) {
        getEntityManager().getTransaction().begin();

        E updated = getEntityManager().merge(entity);

        getEntityManager().getTransaction().commit();

        return updated;
    }

    @Override
    public boolean delete(E e) {
        getEntityManager().getTransaction().begin();
        int id = getEntityManager().createQuery("delete from " + getEntityClass().getSimpleName() + " where id=:id")
                .setParameter("id", e.getId())
                .executeUpdate();
        getEntityManager().getTransaction().commit();
        if (id > 0)
            return true;
        else return false;
    }

    @Override
    public E getById(ID id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    @Override
    public void deleteById(ID id) {
        getEntityManager().getTransaction().begin();
        getEntityManager().createQuery("delete from " + getEntityClass().getSimpleName() + " where id=:id")
                .setParameter("id", id)
                .executeUpdate();
        getEntityManager().getTransaction().commit();
    }

    @Override
    public List<E> findAll() {
        getEntityManager().getTransaction().begin();
        List<E> resultList = getEntityManager().
                createQuery("from " + getEntityClass().getSimpleName(),
                        getEntityClass()).getResultList();
        getEntityManager().getTransaction().commit();
        return resultList;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
