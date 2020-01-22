package com.crm.services.impl;

import com.crm.domain.Office;
import com.crm.repository.OfficeRepository;
import com.crm.services.IOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements IOfficeService {
    @Autowired
    private OfficeRepository  officeRepository;


    @Override
    public Office findById(Long id) {
        return officeRepository.findById(id).get();
    }

    @Override
    public Office save(Office office) {
        return officeRepository.save(office);
    }

    @Override
    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        officeRepository.deleteById(id);
    }
}
