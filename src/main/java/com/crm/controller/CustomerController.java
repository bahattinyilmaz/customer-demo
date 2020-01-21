package com.crm.controller;

import com.crm.domain.Customer;
import com.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
@PreAuthorize("hasRole('ADMIN','CONSULTANT')")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/{cutomerid}")
    public Customer getCustomerById(@RequestParam Long customerid){
        return customerRepository.findById(customerid).get();
    }

    @DeleteMapping("/{cutomerid}")
    public void deleteCustomerById(@RequestParam Long customerid){
        customerRepository.deleteById(customerid);
    }
}
