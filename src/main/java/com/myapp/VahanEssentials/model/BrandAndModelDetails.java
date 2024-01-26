package com.myapp.VahanEssentials.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandAndModelDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "type")
    private String type;

    @ElementCollection
    @CollectionTable(name = "models", joinColumns = @JoinColumn(name = "brand_id"))
    @Column(name = "model")
    private List<String> models;

    public BrandAndModelDetails(Long id, String brand, List<String> models, String type) {
        this.id = id;
        this.brand = brand;
        this.models = models;
        this.type = type;
    }

    public BrandAndModelDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<String> getModels() {
        return models;
    }

    public void setModels(List<String> models) {
        this.models = models;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
