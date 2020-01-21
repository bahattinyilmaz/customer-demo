
package com.crm.controller;

import com.crm.domain.Consultant;
import com.crm.domain.Customer;
import com.crm.domain.Person;
import com.crm.repository.ConsultantRepository;
import com.crm.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultant")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public List<Person> getAllConsultant(){
        return personService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Person createConsultant(@RequestBody Person person){
        return personService.save(person);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{personid}")
    public Person getConsultantById(@RequestParam Long personid){
        return personService.findById(personid);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{personid}")
    public Person activateOrDeactivateByConsultantId(@RequestParam Long personid,boolean isActive){
        Person person = personService.findById(personid);
        person.setIsActive(isActive);
        return personService.save(person);
    }

}
