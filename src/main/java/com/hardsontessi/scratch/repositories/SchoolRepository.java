package com.hardsontessi.scratch.repositories;

import com.hardsontessi.scratch.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}