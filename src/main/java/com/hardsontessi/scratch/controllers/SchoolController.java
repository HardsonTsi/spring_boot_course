package com.hardsontessi.scratch.controllers;

import com.hardsontessi.scratch.entities.School;
import com.hardsontessi.scratch.repositories.SchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    private final SchoolRepository schoolRepository;

    @PostMapping("/schools")
    public School create(@RequestBody School school){
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> findAll(){
        return schoolRepository.findAll();
    }

}
