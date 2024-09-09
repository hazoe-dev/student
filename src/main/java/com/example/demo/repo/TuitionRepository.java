package com.example.demo.repo;

import com.example.demo.entity.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TuitionRepository extends JpaRepository<Tuition, Long> {
    List<Tuition> findByStudentId(Long studentId); // Find all tuitions by student ID
}
