package com.hardsontessi.scratch.mappers;

import com.hardsontessi.scratch.dtos.StudentDTO;
import com.hardsontessi.scratch.dtos.StudentResponseDTO;
import com.hardsontessi.scratch.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDTOtoStudent() {

        StudentDTO dto = new StudentDTO(
                "Tessi",
                "Hardson",
                "hardsontessi2@gmail.com",
                21,
                2
        );

        Student student = studentMapper.toStudent(dto);

        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.email(), student.getEmail());
        assertEquals(dto.age(), student.getAge());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());

    }

    @Test
    public void shouldThrowNullPointerExceptionWhenStudentDTOIsNull() {

        var exception = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
        assertEquals("StudentDTO cannot be null", exception.getMessage());

    }

    @Test
    public void shouldMapStudentToStudentResponseDTO() {

        Student student = new Student(
                null,
                "Tessi",
                "Hardson",
                "hardsontessi2@gmail.com",
                21,
                null,
                null
        );

        StudentResponseDTO dto = studentMapper.toStudentResponseDTO(student);

        assertNotEquals(student.getLastName(), dto.firstName());
        assertEquals(student.getFirstName(), dto.firstName());
        assertEquals(student.getEmail(), dto.email());
        assertEquals(student.getAge(), dto.age());

    }

}