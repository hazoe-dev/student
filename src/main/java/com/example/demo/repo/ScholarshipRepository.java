package com.example.demo.repo;

import com.example.demo.entity.AreaScholarship;
import com.example.demo.entity.PolicyScholarship;
import com.example.demo.entity.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
    List<AreaScholarship> findByAreaCode(String areaCode);

    List<PolicyScholarship> findAllBy();
}
