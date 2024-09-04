package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
    public Student() {
    }

    public Student(Long id, String name, String city, String district, String street) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public Student(String name, String city, String district, String street) {
        this.name = name;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String city;
    private String district;
    private String street;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
