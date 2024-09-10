package com.example.demo.service;

import com.example.demo.entity.Scholarship;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TuitionCalculator {

    public double calculateTotalDiscount(List<Scholarship> scholarships, double tuitionAmount) {
        double totalDiscount = 0.0;

        // Iterate over each scholarship and get its discount
        for (Scholarship scholarship : scholarships) {
            totalDiscount += scholarship.getTotalDiscount(tuitionAmount);
        }

        return totalDiscount;
    }

    public double calculateFinalTuition(List<Scholarship> scholarships, double tuitionAmount) {
        double totalDiscount = calculateTotalDiscount(scholarships, tuitionAmount);
        return tuitionAmount - totalDiscount;
    }
}
