package com.bookstore.dao.base;

import com.bookstore.entity.base.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface BaseDao<E extends BaseEntity<ID>, ID extends Serializable> {

    E create(E e);

    E update(E e);

    boolean delete(E e);

    E getById(ID id);

    void deleteById(ID id);

    List<E> findAll();

    Long count();

    EntityManager getEntityManager();
}
