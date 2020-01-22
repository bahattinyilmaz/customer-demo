package com.crm.services.impl;

import com.crm.domain.SalesChannel;
import com.crm.repository.SalesChannelRepository;
import com.crm.services.ISalesChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesChannelServiceImpl implements ISalesChannelService {

    @Autowired
    private SalesChannelRepository salesChannelRepository;

    @Override
    public SalesChannel findById(Long id) {
        return salesChannelRepository.findById(id).get();
    }

    @Override
    public SalesChannel save(SalesChannel salesChannel) {
        return salesChannelRepository.save(salesChannel);
    }

    @Override
    public List<SalesChannel> findAll() {
        return salesChannelRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        salesChannelRepository.deleteById(id);
    }


}
