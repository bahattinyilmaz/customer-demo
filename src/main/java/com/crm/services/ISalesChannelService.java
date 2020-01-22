package com.crm.services;


import com.crm.domain.SalesChannel;

import java.util.List;

public interface ISalesChannelService {
    SalesChannel findById(Long id);
    SalesChannel save(SalesChannel salesChannel) ;
    List<SalesChannel> findAll();
    void deleteById(Long id);
}
