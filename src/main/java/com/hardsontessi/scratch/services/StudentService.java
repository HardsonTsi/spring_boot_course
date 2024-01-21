package com.hardsontessi.scratch.services;

import com.hardsontessi.scratch.dtos.StudentDTO;
import com.hardsontessi.scratch.dtos.StudentResponseDTO;
import com.hardsontessi.scratch.mappers.StudentMapper;
import com.hardsontessi.scratch.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO post(StudentDTO studentDTO) {
        var student = studentMapper.toStudent(studentDTO);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO findStudentById(Integer id) {
        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDTO)
                .orElse(null);
    }

    public List<StudentResponseDTO> findStudentsByName(String lastName) {
        return studentRepository.findAllByLastNameContaining(lastName)
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }


}
