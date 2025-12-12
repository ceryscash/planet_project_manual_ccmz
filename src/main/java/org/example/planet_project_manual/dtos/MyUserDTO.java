package org.example.planet_project_manual.dtos;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record MyUserDTO(
        int userId,
        @NotBlank(message = "Username is required")
        String username,
        @NotBlank(message = "Role is required")
        String role,
        boolean enabled,
        boolean unlocked,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
