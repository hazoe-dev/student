package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TuitionService tuitionService;

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // Create a new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.insertStudent(student));
    }

    // Update a student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{studentId}/total-tuition")
    public ResponseEntity<Double> getTotalTuition(@PathVariable Long studentId) {
        Double totalTuition = tuitionService.calculateTotalTuition(studentId);
        return ResponseEntity.ok(totalTuition);
    }

    @PutMapping("/{studentId}/address/area-code")
    public ResponseEntity<Student> updateAreaCode(
            @PathVariable Long studentId,
            @RequestParam String areaCode) {

        // Call the service to update the student's area code
        Student updatedStudent = studentService.updateStudentAreaCode(studentId, areaCode);
        return ResponseEntity.ok(updatedStudent);
    }
}

