package com.myapp.BharatAutoCheck.repository;
import com.myapp.BharatAutoCheck.model.InspectionRequest;
import com.myapp.BharatAutoCheck.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InspectionRequestRepository extends JpaRepository<InspectionRequest,Integer> {
}
