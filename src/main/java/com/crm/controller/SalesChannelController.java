package com.crm.controller;

import com.crm.domain.SalesChannel;
import com.crm.services.ISalesChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/saleschannel")
public class SalesChannelController {

    @Autowired
    private ISalesChannelService salesChannelService;

    @GetMapping
    public ResponseEntity<List<SalesChannel>> getAllSalesChannel(){
        return new ResponseEntity<List<SalesChannel>>(salesChannelService.findAll(), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<SalesChannel> createSalesChannel(@RequestBody SalesChannel salesChannel){
        return new ResponseEntity<SalesChannel>(salesChannelService.save(salesChannel), HttpStatus.CREATED) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesChannel> getSalesChannelById(@RequestParam Long id){
        return new ResponseEntity<SalesChannel>(salesChannelService.findById(id), HttpStatus.OK) ;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSalesChannelById(@RequestParam Long id){
        salesChannelService.deleteById(id);
        return new ResponseEntity(null ,HttpStatus.ACCEPTED) ;
    }

}
