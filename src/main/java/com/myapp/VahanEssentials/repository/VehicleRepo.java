package com.myapp.VahanEssentials.repository;
import com.myapp.VahanEssentials.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
    void deleteEmployeeById(Long id);

    Optional<Vehicle> findVehicleById(Long id);
}
