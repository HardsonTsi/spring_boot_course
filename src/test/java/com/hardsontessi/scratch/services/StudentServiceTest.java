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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void shouldReturnAllStudent() {


        List<Student> students = new ArrayList<>();

        students.add(new Student(
                null,
                "TESSI",
                "Hardson",
                "hardsontessi2@gmail.com",
                21
        ));

        Mockito.when(studentRepository.findAll())
                .thenReturn(students);

        Mockito.when(studentMapper.toStudentResponseDTO(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "TESSI",
                        "Hardson",
                        "hardsontessi2@gmail.com",
                        21
                ));

        List<StudentResponseDTO> responseDTOs = studentService.findAllStudents();

        assertEquals(students.size(), responseDTOs.size());

        Mockito.verify(studentRepository, Mockito.times(1))
                .findAll();

    }

    @Test
    public void shoudReturnStudentById() {

        Integer id = 1;

        Student student = new Student(
                null,
                "TESSI",
                "Hardson",
                "hardsontessi2@gmail.com",
                21
        );

        Mockito.when(studentRepository.findById(id))
                .thenReturn(Optional.of(student));

        Mockito.when(studentMapper.toStudentResponseDTO(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "TESSI",
                        "Hardson",
                        "hardsontessi2@gmail.com",
                        21
                ));


        StudentResponseDTO dto = studentService.findStudentById(id);

        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.email(), student.getEmail());

        Mockito.verify(studentRepository, Mockito.times(1))
                .findById(id);

        Mockito.verify(studentMapper, Mockito.times(1))
                .toStudentResponseDTO(student);


    }

    @Test
    public void shouldReturnStudentsByName() {

        String lastName = "TESSI";

        List<Student> students = new ArrayList<>();

        students.add(new Student(
                null,
                "TESSI",
                "Hardson",
                "hardsontessi2@gmail.com",
                21
        ));

        Mockito.when(studentRepository.findAllByLastNameContaining(lastName))
                .thenReturn(students);

        Mockito.when(studentMapper.toStudentResponseDTO(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "TESSI",
                        "Hardson",
                        "hardsontessi2@gmail.com",
                        21
                ));

        var responseDTOs = studentService.findStudentsByName(lastName);

        assertEquals(students.size(), responseDTOs.size());

        Mockito.verify(studentRepository, Mockito.times(1))
                .findAllByLastNameContaining(lastName);

    }


}