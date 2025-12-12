package org.example.planet_project_manual.services;

import org.example.planet_project_manual.dtos.MoonDTO;

import java.util.List;

public interface MoonService {
    MoonDTO addMoon(MoonDTO dto);                       // add a new moon
    List<MoonDTO> findAll();                            // list all moons
    MoonDTO findById(int id);                           // retrieve moon by ID
    void deleteById(int id);                            // delete moon by ID
    List<MoonDTO> findByPlanetName(String planetName);  // list moons for a planet
    int countByPlanetName(String planetName);           // count moons for a planet
}
