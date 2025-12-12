package org.example.planet_project_manual.services;

import org.example.planet_project_manual.dtos.PlanetDTO;
import org.example.planet_project_manual.entities.Planet;

import java.util.List;

public interface PlanetService {
    List<PlanetDTO> findAll();
    PlanetDTO findById(int id);
    PlanetDTO addPlanet(PlanetDTO planetDTO);
    PlanetDTO updateMass(int id, int massKg);
    void deleteById(int id);
    List<Object[]> findPlanetNamesAndMassKg();
    List<PlanetDTO> findByType(String type);
}
