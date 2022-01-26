package com.bookstore.dao.impl;

import com.bookstore.dao.AddressDao;
import com.bookstore.dao.base.BaseDaoImpl;
import com.bookstore.entity.Address;

import javax.persistence.EntityManager;

public class AddressDaoImpl extends BaseDaoImpl<Address,Long> implements AddressDao {
    public AddressDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }
}
