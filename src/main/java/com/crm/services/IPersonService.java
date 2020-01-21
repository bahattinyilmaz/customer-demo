package com.crm.services;

import com.crm.domain.Person;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IPersonService {
    UserDetails loadUserByUsername(String username);
    Person findOne(String username);
    Person findById(Long id);
    Person save(Person person) ;
    List<Person> findAll();
}
