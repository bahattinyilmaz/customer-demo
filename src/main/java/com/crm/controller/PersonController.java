
package com.crm.controller;

import com.crm.domain.Consultant;
import com.crm.domain.Customer;
import com.crm.repository.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultant")
public class ConsultantController {

    @Autowired
    private ConsultantRepository consultantRepository;

    @GetMapping
    public List<Consultant> getAllConsultant(){
        return consultantRepository.findAll();
    }

    @PostMapping
    public Consultant createConsultant(@RequestBody Consultant consultant){
        return consultantRepository.save(consultant);
    }

    @GetMapping("/{consultantid}")
    public Consultant getConsultantById(@RequestParam Long consultantid){
        return consultantRepository.findById(consultantid).get();
    }

    @PutMapping("/{consultantid}")
    public void activateOrDeactivateByConsultantId(@RequestParam Long consultantid,boolean isActive){
        Consultant consultant = consultantRepository.findById(consultantid).orElseThrow();
        consultant.setIsActive(isActive);
        consultantRepository.save(consultant);
    }

}
