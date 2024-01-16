package com.myapp.BharatAutoCheck.employeeResource;

import com.myapp.BharatAutoCheck.model.Vehicle;
import com.myapp.BharatAutoCheck.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class AdminVehicleController {

    @Autowired
    private  final RequestService requestService;

    public AdminVehicleController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/all")
        public ResponseEntity<List<Vehicle>> getAllEmployee(){
        List<Vehicle> requests = requestService.findAllEmployee();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @GetMapping ("find/{id}")
    public ResponseEntity<Vehicle> getEmployeeById(@PathVariable Long id){
        Vehicle request = requestService.findEmployeeById(id);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vehicle> addEmployee(@RequestBody Vehicle request){
        Vehicle newRequest = requestService.addVehicle(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vehicle> updateEmployee(@RequestBody Vehicle request){
        Vehicle updateRequest = requestService.updateEmployee(request);
        return new ResponseEntity<>(updateRequest, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        requestService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
