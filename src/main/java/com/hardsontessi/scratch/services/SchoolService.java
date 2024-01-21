package com.hardsontessi.scratch.services;

import com.hardsontessi.scratch.dtos.SchoolDTO;
import com.hardsontessi.scratch.mappers.SchoolMapper;
import com.hardsontessi.scratch.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }


    public SchoolDTO create(SchoolDTO schoolDTO) {
        var school = schoolMapper.toSchool(schoolDTO);
        schoolRepository.save(school);
        return schoolDTO;
    }

    public List<SchoolDTO> findAll() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDTO)
                .collect(Collectors.toList());

    }

}
