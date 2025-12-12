package org.example.planet_project_manual.services;

import lombok.AllArgsConstructor;
import org.example.planet_project_manual.dtos.Mappers;
import org.example.planet_project_manual.dtos.PlanetDTO;
import org.example.planet_project_manual.entities.Planet;
import org.example.planet_project_manual.exceptions.NotFoundException;
import org.example.planet_project_manual.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanetServiceImplementation implements PlanetService {

    private final PlanetRepository planetRepository;

    @Override
    public List<PlanetDTO> findAll() {
        return planetRepository.findAll()
                .stream()
                .map(Mappers::mapPlanetToPlanetDTO)
                .toList();
    }

    @Override
    public PlanetDTO findById(int id) {
        Planet p = planetRepository.findById((int) id)
                .orElseThrow(() -> new NotFoundException("Planet with id " + id + " not found."));
        return Mappers.mapPlanetToPlanetDTO(p);
    }

    @Override
    public PlanetDTO addPlanet(PlanetDTO dto) {
        Planet p = Mappers.mapPlanetDTOToPlanet(dto);
        Planet saved = planetRepository.save(p);
        return Mappers.mapPlanetToPlanetDTO(saved);
    }

    @Override
    public PlanetDTO updateMass(int id, int massKg) {
        Planet p = planetRepository.findById((int) id)
                .orElseThrow(() -> new NotFoundException("Planet with id " + id + " not found."));
        p.setMassKg(massKg);
        Planet updated = planetRepository.save(p);
        return Mappers.mapPlanetToPlanetDTO(updated);
    }

    @Override
    public void deleteById(int id) {
        Planet p = planetRepository.findById((int) id)
                .orElseThrow(() -> new NotFoundException("Planet with id " + id + " not found."));
        planetRepository.delete(p);
    }

    @Override
    public List<PlanetDTO> findByType(String type) {
        List<Planet> planets = planetRepository.findByType(type); // returns entities
        return planets.stream()
                .map(Mappers::mapPlanetToPlanetDTO) // map each Planet -> PlanetDTO
                .toList();
    }

    @Override
    public List<Object[]> findPlanetNamesAndMassKg() {
        return planetRepository.findPlanetNamesAndMassKg();
    }
}
