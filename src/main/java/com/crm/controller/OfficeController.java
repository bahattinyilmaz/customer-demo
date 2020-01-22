package com.crm.controller;

import com.crm.domain.Office;
import com.crm.domain.SalesChannel;
import com.crm.services.IOfficeService;
import com.crm.services.ISalesChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private IOfficeService officeService;

    @GetMapping
    public ResponseEntity<List<Office>> getAllOffice(){
        return new ResponseEntity<List<Office>>(officeService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Office> createOffice(@RequestBody Office office){
        return new ResponseEntity<Office>(officeService.save(office), HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Office> getOfficeByid(@RequestParam Long id){
        return new ResponseEntity<Office>(officeService.findById(id), HttpStatus.OK) ;

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOfficeById(@RequestParam Long id){
        officeService.deleteById(id);
        return new ResponseEntity(null ,HttpStatus.ACCEPTED) ;
    }

}
