package com.myapp.BharatAutoCheck.repository;
import com.myapp.BharatAutoCheck.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
    void deleteEmployeeById(Long id);

    Optional<Vehicle> findVehicleById(Long id);
}
