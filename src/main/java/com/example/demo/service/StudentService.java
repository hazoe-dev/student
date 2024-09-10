package com.example.demo.service;


import com.example.demo.entity.Address;
import com.example.demo.entity.Scholarship;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ScholarshipService scholarshipService;

    // Get address of a specific student
    public Address getAddressByStudentId(Long studentId) {
        return studentRepository.findAddressByStudentId(studentId);
    }

    // Get list of all addresses
    public List<Address> getAllStudentAddresses() {
        return studentRepository.findAllAddresses();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + studentId));
    }

    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long studentId, Student updatedStudent) {
        Optional<Student> existingStudentOptional = studentRepository.findById(studentId);

        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress(updatedStudent.getAddress());
            return studentRepository.save(existingStudent);
        } else {
            throw new EntityNotFoundException("Student not found with id: " + studentId);
        }
    }

    public void deleteStudent(Long studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
        } else {
            throw new EntityNotFoundException("Student not found with id: " + studentId);
        }
    }
    public List<Scholarship> getStudentScholarships(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        return scholarshipService.getScholarshipsByStudent(student);
    }

    @Transactional
    public Student updateStudentAreaCode(Long studentId, String newAreaCode) {
        // Fetch the student by their ID
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            // Update the area code in the address
            Address address = student.getAddress();
            if (address != null) {
                address.setAreaCode(newAreaCode);
                student.setAddress(address); // Update the student's address
                return studentRepository.save(student); // Save the updated student
            } else {
                throw new IllegalStateException("Student does not have an address");
            }
        } else {
            throw new IllegalArgumentException("Student not found with ID: " + studentId);
        }
    }
}

