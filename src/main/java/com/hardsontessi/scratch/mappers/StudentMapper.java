package com.hardsontessi.scratch.mappers;

import com.hardsontessi.scratch.dtos.StudentDTO;
import com.hardsontessi.scratch.dtos.StudentResponseDTO;
import com.hardsontessi.scratch.entities.School;
import com.hardsontessi.scratch.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toStudent(StudentDTO studentDTO) {

        if (studentDTO == null)
            throw new NullPointerException("StudentDTO cannot be null");

        var student = new Student();

        student.setLastName(studentDTO.lastName());
        student.setFirstName(studentDTO.firstName());
        student.setEmail(studentDTO.email());
        student.setAge(studentDTO.age());

        var school = new School();
        school.setId(studentDTO.schoolId());
        student.setSchool(school);

        return student;

    }

    public StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getLastName(),
                student.getFirstName(),
                student.getEmail(),
                student.getAge()
        );
    }

}
