package com.example.demo.service;

import com.example.demo.entity.AreaScholarship;
import com.example.demo.entity.PolicyScholarship;
import com.example.demo.repo.ScholarshipRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScholarshipService {

    @Autowired
    private ScholarshipRepository scholarshipRepository;

    @PostConstruct
    public void init() {
        // Create and save AreaScholarship
        AreaScholarship areaScholarship = new AreaScholarship("Area-based Scholarship", "AREA123", 5000.00);
        scholarshipRepository.save(areaScholarship);

        // Create and save PolicyScholarship
        PolicyScholarship policyScholarship = new PolicyScholarship("Policy-based Scholarship", 25.0);
        scholarshipRepository.save(policyScholarship);
    }
}
