package com.myapp.BharatAutoCheck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "VehicleDetails")
public class VehicleDetails implements Serializable {

    @Id
    @Column(name = "VehicleNumber")
    private String vehicleNumber;

    @Column(name = "VehicleType")
    private String vehicleType;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Make")
    private int make;

    @Column(name = "ChassisNo")
    private String chassisNo;

    @Column(name = "EngineNo")
    private String engineNo;

    public VehicleDetails(String vehicleNumber, String vehicleType, String brand, String model, int make, String chassisNo, String engineNo) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.make = make;
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
    }

    public VehicleDetails() {
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMake() {
        return make;
    }

    public void setMake(int make) {
        this.make = make;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }
}