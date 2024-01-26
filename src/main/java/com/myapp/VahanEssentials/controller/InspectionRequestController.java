package com.myapp.VahanEssentials.controller;

import com.myapp.VahanEssentials.model.InspectionRequest;
import com.myapp.VahanEssentials.service.InspectionRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InspectionRequestController {

     private final InspectionRequestService inspectionRequestService;

     public InspectionRequestController(InspectionRequestService inspectionRequestService) {
         this.inspectionRequestService = inspectionRequestService;
     }

    @PostMapping("/add/inspection-request")
    public ResponseEntity<?> createInspectionRequest(@RequestBody InspectionRequest inspectionRequest) {
        return inspectionRequestService.saveRequest(inspectionRequest);
    }
}
