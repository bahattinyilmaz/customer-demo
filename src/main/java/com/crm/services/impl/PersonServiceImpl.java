package com.crm.services.impl;

import com.crm.domain.Person;
import com.crm.repository.PersonRepository;
import com.crm.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class PersonServiceImpl implements IPersonService, UserDetailsService {

    @Autowired
    private  PersonRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) {
        Person person = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username)));
        return new User(person.getUsername(), person.getPassword(),getAuthority(person));
    }

    private Set getAuthority(Person person) {
        Set authorities = new HashSet<>();
        person.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    @Override
    public Person findByName(String username) {
        return userRepository.findByUserName(username).get();
    }

    @Override
    public Person findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Person save(Person person) {
        person.setPassword(bcryptEncoder.encode(person.getPassword()));
        return userRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return userRepository.findAll();
    }
}
