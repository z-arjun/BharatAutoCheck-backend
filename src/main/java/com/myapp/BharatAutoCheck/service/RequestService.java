package com.myapp.BharatAutoCheck.service;

import com.myapp.BharatAutoCheck.exception.VehicleNotFountException;
import com.myapp.BharatAutoCheck.model.Vehicle;
import com.myapp.BharatAutoCheck.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RequestService {
    private final VehicleRepo vehicleRepo;

    @Autowired
    public RequestService(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public Vehicle addVehicle(Vehicle request){
        return vehicleRepo.save(request);
    }

    public List<Vehicle> findAllEmployee(){
        return  vehicleRepo.findAll();
    }

    public Vehicle updateEmployee(Vehicle request){
        return vehicleRepo.save(request);
    }

    public void deleteEmployee(Long id){
        vehicleRepo.deleteEmployeeById(id);
    }

    public Vehicle findEmployeeById(Long id){
        return vehicleRepo.findVehicleById(id).orElseThrow(() ->new VehicleNotFountException("Vehicle by ID:"+id+" was not found"));
    }
}
