package com.myapp.BharatAutoCheck.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Vehicle implements Serializable{

    @Id
    private String id;
    private String vehicleNumber;
    private String model;
    private int year;
    private String vehicleType;

    // Constructor

    public Vehicle(String id, String vehicleNumber, String model, int year, String vehicleType) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.year = year;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}

