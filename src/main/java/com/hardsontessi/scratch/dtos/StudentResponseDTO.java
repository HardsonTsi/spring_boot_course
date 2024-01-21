package com.hardsontessi.scratch.dtos;

public record StudentResponseDTO(
        String lastName,
        String firstName,
        String email,
        Integer age
) {
}
