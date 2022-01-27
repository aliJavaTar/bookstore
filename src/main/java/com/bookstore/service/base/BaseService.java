package com.bookstore.service.base;

import com.bookstore.entity.base.BaseEntity;

import java.io.Serializable;
import java.util.List;


public interface BaseService<E extends BaseEntity<ID>, ID extends Serializable> {
    E create(E e);

    E update(E e);

    boolean delete(E e);

    void deleteByID(ID id);

    E findById(ID id);


    List<E> findAll();

}
