package com.myapp.VahanEssentials.service;

import com.myapp.VahanEssentials.exception.VehicleNotFountException;
import com.myapp.VahanEssentials.model.BrandAndModelDetails;
import com.myapp.VahanEssentials.model.Vehicle;
import com.myapp.VahanEssentials.repository.BrandAndModelDetailsRepository;
import com.myapp.VahanEssentials.repository.VehicleDetailsRepository;
import com.myapp.VahanEssentials.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminRequestService {
    private final VehicleRepo vehicleRepo;
    private final VehicleDetailsRepository vehicleDetailsRepository;
    private final BrandAndModelDetailsRepository brandAndModelDetailsRepository;


    @Autowired
    public AdminRequestService(VehicleRepo vehicleRepo, VehicleDetailsRepository vehicleDetailsRepository, BrandAndModelDetailsRepository brandAndModelDetailsRepository) {
        this.vehicleRepo = vehicleRepo;
        this.vehicleDetailsRepository = vehicleDetailsRepository;
        this.brandAndModelDetailsRepository = brandAndModelDetailsRepository;
    }

    public String addVehicle(List<BrandAndModelDetails> request){
        brandAndModelDetailsRepository.saveAll(request);
        return "added";
    }

    public List<BrandAndModelDetails> findAllVehiclesDetails(String type){
        return (List<BrandAndModelDetails>) brandAndModelDetailsRepository.findAllByType(type);
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
