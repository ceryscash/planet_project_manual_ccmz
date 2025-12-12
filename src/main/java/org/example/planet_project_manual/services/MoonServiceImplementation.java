package org.example.planet_project_manual.services;

import lombok.AllArgsConstructor;
import org.example.planet_project_manual.dtos.Mappers;
import org.example.planet_project_manual.dtos.MoonDTO;
import org.example.planet_project_manual.entities.Moon;
import org.example.planet_project_manual.entities.Planet;
import org.example.planet_project_manual.exceptions.NotFoundException;
import org.example.planet_project_manual.repositories.MoonRepository;
import org.example.planet_project_manual.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MoonServiceImplementation implements MoonService {

    private final MoonRepository moonRepository;
    private final PlanetRepository planetRepository;

    @Override
    public MoonDTO addMoon(MoonDTO dto) {
        Planet planet = planetRepository.findById(dto.planet().planetId())
                .orElseThrow(() -> new NotFoundException("Planet not found with id " + dto.planet().planetId()));

        Moon moon = Mappers.mapMoonDTOToMoon(dto, planet);

        Moon saved = moonRepository.save(moon);

        return Mappers.mapMoonToMoonDTO(saved);
    }

    @Override
    public List<MoonDTO> findAll() {
        return moonRepository.findAll()
                .stream()
                .map(Mappers::mapMoonToMoonDTO)
                .toList();
    }

    @Override
    public MoonDTO findById(int id) {
        Moon moon = moonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Moon with id " + id + " not found."));
        return Mappers.mapMoonToMoonDTO(moon);
    }

    @Override
    public void deleteById(int id) {
        Moon moon = moonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Moon with id " + id + " not found."));
        moonRepository.delete(moon);
    }

    @Override
    public List<MoonDTO> findByPlanetName(String planetName) {
        return moonRepository.findByPlanetName(planetName)
                .stream()
                .map(Mappers::mapMoonToMoonDTO)
                .toList();
    }

    @Override
    public int countByPlanetName(String planetName) {
        return moonRepository.countByPlanetName(planetName);
    }
}
