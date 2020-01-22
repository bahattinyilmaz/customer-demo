
package com.crm.controller;

import com.crm.domain.Person;
import com.crm.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        return new ResponseEntity<List<Person>>(personService.findAll(), HttpStatus.CREATED) ;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<Person>(personService.save(person), HttpStatus.CREATED) ;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{personid}")
    public Person getPersonById(@RequestParam Long personid){
        return personService.findById(personid);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{personid}")
    public ResponseEntity<Person> activateOrDeactivateByPersonById(@RequestParam Long personid, boolean isActive){
        Person person = personService.findById(personid);
        person.setIsActive(isActive);
        return new ResponseEntity<Person>(personService.save(person), HttpStatus.ACCEPTED) ;
    }

}
