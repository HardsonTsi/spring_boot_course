package com.hardsontessi.scratch.controllers;

import com.hardsontessi.scratch.entities.Student;
import com.hardsontessi.scratch.repositories.StudentReposity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    public StudentController(StudentReposity studentReposity) {
        this.studentReposity = studentReposity;
    }

    private final StudentReposity studentReposity;

    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return studentReposity.save(student);
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
