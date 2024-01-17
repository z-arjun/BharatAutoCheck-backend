package com.myapp.BharatAutoCheck.controller.employeeResource;

import com.myapp.BharatAutoCheck.model.Vehicle;
import com.myapp.BharatAutoCheck.model.VehicleDetails;
import com.myapp.BharatAutoCheck.service.AdminRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class AdminVehicleController {

    @Autowired
    private  final AdminRequestService adminRequestService;

    public AdminVehicleController(AdminRequestService adminRequestService) {
        this.adminRequestService = adminRequestService;
    }

    @GetMapping("/all")
        public ResponseEntity<List<VehicleDetails>> getAllEmployee(){
        List<VehicleDetails> requests = adminRequestService.findAllVehiclesDetails();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping ("find/{id}")
    public ResponseEntity<Vehicle> getEmployeeById(@PathVariable Long id){
        Vehicle request = adminRequestService.findEmployeeById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vehicle> addEmployee(@RequestBody Vehicle request){
        Vehicle newRequest = adminRequestService.addVehicle(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vehicle> updateEmployee(@RequestBody Vehicle request){
        Vehicle updateRequest = adminRequestService.updateEmployee(request);
        return new ResponseEntity<>(updateRequest, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        adminRequestService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
