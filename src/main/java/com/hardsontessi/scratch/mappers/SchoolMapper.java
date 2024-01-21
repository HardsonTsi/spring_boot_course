package com.hardsontessi.scratch.mappers;

import com.hardsontessi.scratch.dtos.SchoolDTO;
import com.hardsontessi.scratch.entities.School;
import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    public School toSchool(SchoolDTO schoolDTO) {
        var school = new School();
        school.setName(schoolDTO.name());
        return school;
    }

    public SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }


}
