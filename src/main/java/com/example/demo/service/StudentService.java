package com.example.demo.service;


import com.example.demo.entity.Address;
import com.example.demo.entity.Scholarship;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

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
        return student.getScholarships(); // This will return a list of scholarships based on the logic
    }
}

