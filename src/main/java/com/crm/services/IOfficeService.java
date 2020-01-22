package com.crm.services;

import com.crm.domain.Office;
import com.crm.domain.SalesChannel;

import java.util.List;

public interface IOfficeService {
    Office findById(Long id);
    Office save(Office person) ;
    List<Office> findAll();
    void deleteById(Long id);
}
