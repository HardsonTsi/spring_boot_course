package com.hardsontessi.scratch.controllers;

import com.hardsontessi.scratch.dtos.StudentDTO;
import com.hardsontessi.scratch.dtos.StudentResponseDTO;
import com.hardsontessi.scratch.entities.Student;
import com.hardsontessi.scratch.repositories.SchoolRepository;
import com.hardsontessi.scratch.repositories.StudentReposity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentReposity studentReposity;
    private final SchoolRepository schoolRepository;

    public StudentController(StudentReposity studentReposity, SchoolRepository schoolRepository) {
        this.studentReposity = studentReposity;
        this.schoolRepository = schoolRepository;
    }

    private Student toStudent(StudentDTO studentDTO) {

        var student = new Student();

        student.setLastName(studentDTO.lastName());
        student.setFirstName(studentDTO.firstName());
        student.setEmail(studentDTO.email());
        student.setAge(studentDTO.age());

        var school = schoolRepository.findById(studentDTO.schoolId()).orElse(null);
        student.setSchool(school);

        return student;

    }

    private StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getLastName(),
                student.getFirstName(),
                student.getEmail(),
                student.getAge()
        );
    }

    @PostMapping("/students")
    public StudentResponseDTO post(@RequestBody StudentDTO studentDTO) {
        var student = toStudent(studentDTO);
        var savedStudent = studentReposity.save(student);
        return toStudentResponseDTO(savedStudent);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentReposity.findAll();
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable("id") Integer id) {
        return studentReposity.findById(id).orElse(null);
    }

    @GetMapping("/students/search/{lastName}")
    public List<Student> findStudentsByName(@PathVariable("lastName") String lastName) {
        return studentReposity.findAllByLastNameContaining(lastName);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("id") Integer id) {
        studentReposity.deleteById(id);
    }

}
