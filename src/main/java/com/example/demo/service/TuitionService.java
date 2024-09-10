package com.example.demo.service;
import com.example.demo.entity.Scholarship;
import com.example.demo.entity.Student;
import com.example.demo.entity.Tuition;
import com.example.demo.repo.TuitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TuitionService {

    @Autowired
    private TuitionRepository tuitionRepository;

    @Autowired
    private TuitionCalculator calculator;

    public Double calculateTotalTuition(Long studentId) {
        // Get the student tuitions
        List<Tuition> tuitions = tuitionRepository.findByStudentId(studentId);

        // Sum up all tuition amounts
        Double totalTuition = tuitions.stream()
                .mapToDouble(Tuition::getAmount)
                .sum();

        // Get the student scholarships
        Student student = tuitions.get(0).getStudent(); // Assuming there's at least one tuition
        List<Scholarship> scholarships = student.getScholarships();

        // Apply discount
        Double discountedTuition = calculator.calculateFinalTuition(scholarships,totalTuition);

        // Ensure discounted tuition is not negative
        return Math.max(discountedTuition, 0.0);
    }
}
