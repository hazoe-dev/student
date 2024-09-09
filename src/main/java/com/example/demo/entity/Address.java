package com.example.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String district;
    private String street;
    private String areaCode;

    public Address() {}

    public Address(String city, String district, String street) {
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public Address(String city, String district, String street, String areaCode) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.areaCode = areaCode;
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
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }


    @Override
    public String toString() {
        return "\nAddress{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
