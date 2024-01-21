package com.hardsontessi.scratch.controllers;

import com.hardsontessi.scratch.dtos.StudentDTO;
import com.hardsontessi.scratch.dtos.StudentResponseDTO;
import com.hardsontessi.scratch.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDTO post(
            @Valid @RequestBody StudentDTO studentDTO
    ) {
        return studentService.saveStudent(studentDTO);
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentResponseDTO findStudentById(
            @PathVariable("id") Integer id
    ) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{lastName}")
    public List<StudentResponseDTO> findStudentsByName(
            @PathVariable("lastName") String lastName
    ) {
        return studentService.findStudentsByName(lastName);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("id") Integer id
    ) {
        studentService.deleteStudentById(id);
    }

}
