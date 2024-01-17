package com.myapp.BharatAutoCheck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "InspectionRequest")
public class InspectionRequest implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inspectionId;

    @Column(name = "RequestTime")
    private LocalDate requestTime;

    @Column(name = "Status")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VehicleNumber", referencedColumnName = "VehicleNumber")
    private VehicleDetails vehicleDetails;

    public InspectionRequest(int inspectionId, LocalDate requestTime, String status, VehicleDetails vehicleDetails) {
        this.inspectionId = inspectionId;
        this.requestTime = requestTime;
        this.status = status;
        this.vehicleDetails = vehicleDetails;
    }

    public InspectionRequest() {
    }

    public int getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }

    public LocalDate getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDate requestTime) {
        this.requestTime = requestTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
}