package com.myapp.VahanEssentials.service;

import com.myapp.VahanEssentials.model.InspectionRequest;
import org.springframework.http.ResponseEntity;

public interface InspectionRequestService {

    public ResponseEntity<?> saveRequest(InspectionRequest inspectionRequest);
}
