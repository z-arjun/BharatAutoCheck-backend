package com.myapp.BharatAutoCheck.service;

import com.myapp.BharatAutoCheck.model.InspectionRequest;
import com.myapp.BharatAutoCheck.repository.InspectionRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class InspectionRequestServiceImpl implements InspectionRequestService {

    @Autowired
    InspectionRequestRepository inspectionRequestRepository;

    public static final Logger log = LoggerFactory.getLogger(InspectionRequestServiceImpl.class);
    @Override
    public ResponseEntity<?> saveRequest(InspectionRequest inspectionRequest) {
        try {
            inspectionRequestRepository.save(inspectionRequest);
        } catch (Exception e) {
            log.error("Error occurred during save operation {}", e.getMessage());
            return new ResponseEntity<>("Error occurred during save operation", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Data saved successfully", HttpStatus.OK);
    }
}
