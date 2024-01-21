package com.hardsontessi.scratch.controllers;

import com.hardsontessi.scratch.dtos.SchoolDTO;
import com.hardsontessi.scratch.services.SchoolService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDTO create(@RequestBody SchoolDTO schoolDTO) {
        return schoolService.create(schoolDTO);
    }

    @GetMapping("/schools")
    public List<SchoolDTO> findAll() {
        return schoolService.findAll();
    }

}
