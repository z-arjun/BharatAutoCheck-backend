package com.myapp.BharatAutoCheck.service;

import com.myapp.BharatAutoCheck.model.InspectionRequest;
import org.springframework.http.ResponseEntity;

public interface InspectionRequestService {

    public ResponseEntity<?> saveRequest(InspectionRequest inspectionRequest);
}
