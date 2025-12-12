package org.example.planet_project_manual.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MoonDTO (
    int moonId,
    @NotBlank(message = "Moon name is required")
    String name,
    int diameterKm,
    int orbitalPeriodDays,
    @NotNull(message = "Planet is required")
    PlanetDTO planet
    )
{}
