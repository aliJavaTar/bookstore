package com.bookstore.service.base;

import com.bookstore.dao.base.BaseDao;
import com.bookstore.entity.base.BaseEntity;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID> ,ID extends Serializable ,Dao extends BaseDao<E,ID>> implements BaseService<E,ID>{
    protected final Dao repository;

    public BaseServiceImpl(Dao repository) {
        this.repository = repository;
    }

    @Override
    public E create(E e) {
    //    repository.getEntityManager().getTransaction().begin();
        e = repository.create(e);
    //    repository.getEntityManager().getTransaction().commit();
        return e;
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public boolean delete(E e) {
        return repository.delete(e);
    }

    @Override
    public void deleteByID(ID id) {
       repository.deleteById(id);
    }

    @Override
    public E findById(ID id) {
        return repository.getById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
}
