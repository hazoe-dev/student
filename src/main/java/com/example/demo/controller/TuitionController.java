package com.example.demo.controller;

import com.example.demo.entity.Tuition;
import com.example.demo.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tuition")
public class TuitionController {

    @Autowired
    private TuitionService tuitionService;

    @PostMapping
    public ResponseEntity<Tuition> createTuition(@RequestParam Long studentId, @RequestParam Double amount) {
        Tuition tuition = tuitionService.createTuition(studentId, amount);
        return ResponseEntity.ok(tuition);
    }
}
