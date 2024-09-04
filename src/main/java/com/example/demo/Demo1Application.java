package com.example.demo;

import com.example.demo.entity.Address;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {


    @Autowired
    StudentRepository repository;

    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = SpringApplication.run(Demo1Application.class, args);
        SearchServiceImpl searchService = appContext.getBean(SearchServiceImpl.class);
        int result = searchService.search(new int[]{12, 5, 7}, 5);
        System.out.println(result);

    }

    @Override
    public void run(String... args) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("User id 10001 -> {}", repository.findById(100l));

        Address address;
        logger.info("Inserting -> {}",
        repository.save(new Student("John Doe", new Address("CityName1", "DistrictName1", "StreetName1"))));

        logger.info("Update 2 -> {}",
                repository.save(new Student(200l, "Zoe", new Address("CityName1", "DistrictName1", "StreetName1"))));

        repository.deleteById(300l);

        logger.info("All users -> {}", repository.findAll());
    }
}
