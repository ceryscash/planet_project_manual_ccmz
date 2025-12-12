package org.example.planet_project_manual.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PlanetDTO (
        int planetId,
        @NotBlank(message = "Planet name is required")
        String name,
        String type,
        int radiusKm,
        int massKg,
        int orbitalPeriodDays,
        List<MoonDTO> moons
) {}