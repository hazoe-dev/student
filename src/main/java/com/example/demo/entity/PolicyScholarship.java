package com.example.demo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("POLICY")
public class PolicyScholarship extends Scholarship {

    private Double percentageAmount;

    public PolicyScholarship() {}

    public PolicyScholarship(String name, Double percentageAmount) {
        super(name);
        this.percentageAmount = percentageAmount;
    }

    public Double getPercentageAmount() {
        return percentageAmount;
    }

    public void setPercentageAmount(Double percentageAmount) {
        this.percentageAmount = percentageAmount;
    }
}
