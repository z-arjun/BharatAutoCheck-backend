package com.myapp.BharatAutoCheck.repository;
import com.myapp.BharatAutoCheck.model.InspectionRequest;
import com.myapp.BharatAutoCheck.model.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails,Integer> {
}
