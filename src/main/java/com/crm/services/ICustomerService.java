package com.crm.services;

import com.crm.domain.Customer;
import com.crm.domain.Person;

import java.util.List;

public interface ICustomerService {
    Customer findById(Long id);
    Customer save(Customer customer) ;
    List<Customer> findAll();
}
