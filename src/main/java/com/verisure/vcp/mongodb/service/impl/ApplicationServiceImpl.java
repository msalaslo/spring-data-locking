package com.verisure.vcp.mongodb.service.impl;

import com.verisure.vcp.mongodb.domain.entity.ApplicationItem;
import com.verisure.vcp.mongodb.domain.repository.ApplicationRepository;
import com.verisure.vcp.mongodb.service.ApplicationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * Sample service implementation.
 *
 * @since 1.0.0
 * @author FaaS [faas@securitasdirect.es]
 */
@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public void createApplicationItem(ApplicationItem applicationItem) {
        applicationRepository.save(applicationItem);
    }

    @Override
    public List<ApplicationItem> getApplicationItems() {
      return applicationRepository.findAll();
    }

}
