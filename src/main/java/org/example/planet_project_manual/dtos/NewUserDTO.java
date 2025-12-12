package org.example.planet_project_manual.dtos;

import jakarta.validation.constraints.NotBlank;

public record NewUserDTO(
        @NotBlank(message = "Username is required")
        String username,

        @NotBlank(message = "Password is required")
        String password,

        @NotBlank(message = "Role is required")
        String role
) {}
