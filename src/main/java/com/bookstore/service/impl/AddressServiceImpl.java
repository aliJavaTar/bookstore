package com.bookstore.service.impl;

import com.bookstore.dao.AddressDao;
import com.bookstore.entity.Address;
import com.bookstore.service.AddressService;
import com.bookstore.service.base.BaseServiceImpl;

public class AddressServiceImpl extends BaseServiceImpl<Address,Long, AddressDao> implements AddressService {
    public AddressServiceImpl(AddressDao repository) {
        super(repository);
    }
}
