package com.hardsontessi.scratch.services;

import com.hardsontessi.scratch.dtos.StudentDTO;
import com.hardsontessi.scratch.dtos.StudentResponseDTO;
import com.hardsontessi.scratch.entities.Student;
import com.hardsontessi.scratch.mappers.StudentMapper;
import com.hardsontessi.scratch.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void shoudSuccessfullyCreateStudent() {

        StudentDTO dto = new StudentDTO(
                "TESSI",
                "Hardson",
                "hardsontessi2@gmail.com",
                21,
                1
        );

        Student student = new Student(
                null,
                "TESSI",
                "Hardson",
                "hardsontessi2@gmail.com",
                21
        );

        Student savedStudent = new Student(
                null,
                "TESSI",
                "Hardson",
                "hardsontessi2@gmail.com",
                21
        );

        savedStudent.setId(1);

        Mockito.when(studentMapper.toStudent(dto))
                .thenReturn(student);
        Mockito.when(studentRepository.save(student))
                .thenReturn(savedStudent);
        Mockito.when(studentMapper.toStudentResponseDTO(savedStudent))
                .thenReturn(new StudentResponseDTO(
                        "TESSI",
                        "Hardson",
                        "hardsontessi2@gmail.com",
                        21
                ));


        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        Mockito.verify(studentMapper, Mockito.times(1))
                .toStudent(dto);

        Mockito.verify(studentRepository, Mockito.times(1))
                .save(student);

        Mockito.verify(studentMapper, Mockito.times(1))
                .toStudentResponseDTO(savedStudent);

    }


}