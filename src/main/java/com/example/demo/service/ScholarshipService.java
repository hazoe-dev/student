package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repo.ScholarshipRepository;
import com.example.demo.repo.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScholarshipService {

    @Autowired
    private ScholarshipRepository scholarshipRepository;

    public List<Scholarship> getScholarshipsByStudent(Student student) {
        List<Scholarship> scholarships = new ArrayList<>();

        // Add PolicyScholarship if the student is from a policy family
        if (Boolean.TRUE.equals(student.getIsPolicyFamily())) {
            List<PolicyScholarship> policyScholarships = scholarshipRepository.findAllBy();
            scholarships.addAll(policyScholarships);
        }

        // Add AreaScholarship based on the area code in the student's address
        Address address = student.getAddress();
        if (address != null && address.getAreaCode() != null) {
            List<AreaScholarship> areaScholarships =
                    scholarshipRepository.findByAreaCode(address.getAreaCode());
            scholarships.addAll(areaScholarships);
        }

        return scholarships;
    }

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
