package com.hardsontessi.scratch.repositories;

import com.hardsontessi.scratch.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByLastNameContaining(String lastName);
}
