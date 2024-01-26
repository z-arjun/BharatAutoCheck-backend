package com.myapp.VahanEssentials.repository;
import com.myapp.VahanEssentials.model.InspectionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRequestRepository extends JpaRepository<InspectionRequest,Integer> {
}
