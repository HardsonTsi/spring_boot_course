package com.hardsontessi.scratch.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty
        String lastName,
        @NotEmpty
        String firstName,
        @NotEmpty
        @Email(message = "Please provide a valid email address")
        String email,
        @Min(3)
        Integer age,
        Integer schoolId
) {
}