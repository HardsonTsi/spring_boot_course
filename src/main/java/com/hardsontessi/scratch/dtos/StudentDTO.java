package com.hardsontessi.scratch.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record StudentDTO(
        @NotEmpty
        String lastName,
        @NotEmpty
        String firstName,
        @NotEmpty
        @Email(message = "Please provide a valid email address")
        String email,
        @Positive
        Integer age,
        Integer schoolId
) {
}