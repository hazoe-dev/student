package com.example.demo.repo;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long > {
    @Query("SELECT s.address FROM Student s WHERE s.id = :studentId")
    Address findAddressByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT s.address FROM Student s")
    List<Address> findAllAddresses();
}
