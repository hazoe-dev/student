package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Tuition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Constructors
    public Tuition() {}

    public Tuition(Double amount, Student student) {
        this.amount = amount;
        this.student = student;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    // Other getters and setters...
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
