package com.hardsontessi.scratch.controllers;

import com.hardsontessi.scratch.dtos.SchoolDTO;
import com.hardsontessi.scratch.entities.School;
import com.hardsontessi.scratch.repositories.SchoolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    private School toSchool(SchoolDTO schoolDTO) {
        var school = new School();
        school.setName(schoolDTO.name());
        return school;
    }

    private SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }

    @PostMapping("/schools")
    public SchoolDTO create(@RequestBody SchoolDTO schoolDTO) {
        var school = toSchool(schoolDTO);
        schoolRepository.save(school);
        return schoolDTO;
    }

    @GetMapping("/schools")
    public List<SchoolDTO> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDTO)
                .collect(Collectors.toList());

    }

}
