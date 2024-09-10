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
    private StudentService studentService;

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
        List<Scholarship> scholarships = studentService.getStudentScholarships(studentId);

        // Apply discount
        Double discountedTuition = calculator.calculateFinalTuition(scholarships,totalTuition);

        // Ensure discounted tuition is not negative
        return Math.max(discountedTuition, 0.0);
    }

    public Tuition createTuition(Long studentId, Double amount) {
        Student student = studentService.getStudentById(studentId); // Fetch the student by ID
        Tuition tuition = new Tuition();
        tuition.setStudent(student);
        tuition.setAmount(amount);
        return tuitionRepository.save(tuition); // Save to the database
    }
}
