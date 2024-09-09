package com.example.demo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AREA")
public class AreaScholarship extends Scholarship {

    private String areaCode;
    private Double discountAmount;

    // Constructors, Getters, and Setters

    public AreaScholarship() {}

    public AreaScholarship(String name, String areaCode, Double discountAmount) {
        super(name);
        this.areaCode = areaCode;
        this.discountAmount = discountAmount;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }
}
