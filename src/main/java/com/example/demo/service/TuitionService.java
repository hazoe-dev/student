package com.example.demo.service;
import com.example.demo.entity.*;
import com.example.demo.repo.ScholarshipRepository;
import com.example.demo.repo.TuitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TuitionService {

    @Autowired
    private TuitionRepository tuitionRepository;

    @Autowired
    private ScholarshipRepository scholarshipRepository;

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

        // Initialize discount amounts
        Double totalDiscount = 0.0;
        Double totalPercentageDiscount = 0.0;

        // Loop through scholarships and calculate total discount
        for (Scholarship scholarship : scholarships) {
            if (scholarship instanceof AreaScholarship) {
                // AreaScholarship has a discount amount
                AreaScholarship areaScholarship = (AreaScholarship) scholarship;
                totalDiscount += areaScholarship.getDiscountAmount();
            } else if (scholarship instanceof PolicyScholarship) {
                // PolicyScholarship has a percentage discount
                PolicyScholarship policyScholarship = (PolicyScholarship) scholarship;
                totalPercentageDiscount += policyScholarship.getPercentageAmount();
            }
        }

        // Apply percentage discount first
        Double percentageDiscount = (totalPercentageDiscount / 100) * totalTuition;
        Double discountedTuition = totalTuition - percentageDiscount;

        // Apply fixed amount discount
        discountedTuition -= totalDiscount;

        // Ensure discounted tuition is not negative
        return Math.max(discountedTuition, 0.0);
    }
}
