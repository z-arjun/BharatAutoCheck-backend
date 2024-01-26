package com.myapp.VahanEssentials.controller;

import com.myapp.VahanEssentials.model.BrandAndModelDetails;
import com.myapp.VahanEssentials.model.Vehicle;
import com.myapp.VahanEssentials.service.AdminRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private  final AdminRequestService adminRequestService;

    public VehicleController(AdminRequestService adminRequestService) {
        this.adminRequestService = adminRequestService;
    }

    @GetMapping("/all/{vehicleType}")
        public ResponseEntity<List<BrandAndModelDetails>> getAllVehicleDetails(@PathVariable String vehicleType){
        List<BrandAndModelDetails> requests = adminRequestService.findAllVehiclesDetails(vehicleType.toUpperCase());
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@RequestBody List<BrandAndModelDetails> request){
        String newRequest = adminRequestService.addVehicle(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

}
