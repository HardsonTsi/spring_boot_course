package com.hardsontessi.scratch.dtos;

public record StudentDTO(
        String lastName,
        String firstName,
        String email,
        Integer age,
        Integer schoolId
) {
}