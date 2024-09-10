package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Boolean isPolicyFamily; // New field

    @Embedded
    private Address address;

    public Student() {}

    public Student(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Student(String name, Boolean isPolicyFamily, Address address) {
        this.name = name;
        this.isPolicyFamily = isPolicyFamily;
        this.address = address;
    }

    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getIsPolicyFamily() {
        return isPolicyFamily;
    }

    public void setIsPolicyFamily(Boolean isPolicyFamily) {
        this.isPolicyFamily = isPolicyFamily;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Tuition> tuitions;

    public List<Tuition> getTuitions() {
        return tuitions;
    }

    public void setTuitions(List<Tuition> tuitions) {
        this.tuitions = tuitions;
    }

}
