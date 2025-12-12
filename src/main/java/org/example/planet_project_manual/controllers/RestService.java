package org.example.planet_project_manual.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.planet_project_manual.dtos.MoonDTO;
import org.example.planet_project_manual.dtos.PlanetDTO;
import org.example.planet_project_manual.services.MoonService;
import org.example.planet_project_manual.services.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class RestService {

    private final MoonService moonService;
    private final PlanetService planetService;

    // add a new planet
    @PostMapping("/planets")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    @ResponseStatus(HttpStatus.CREATED)
    public PlanetDTO addPlanet(@Valid @RequestBody PlanetDTO dto) {
        return planetService.addPlanet(dto);
    }

    // retrieve all planets
    @GetMapping("/planets")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'STUDENT')")
    public List<PlanetDTO> findAllPlanets() {
        return planetService.findAll();
    }


    // retrieve a planet by its unique ID
    @GetMapping("/planets/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'STUDENT')")
    public PlanetDTO findPlanetById(@PathVariable int id) {
        return planetService.findById(id);
    }

    // update the mass of an existing planet
    @PutMapping("/planets/{id}/mass")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public PlanetDTO updatePlanetMass(@PathVariable int id, @RequestParam int massKg) {
        return planetService.updateMass(id, massKg);
    }

    // remove a planet by its unique ID
    @DeleteMapping("/planets/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlanet(@PathVariable int id) {
        planetService.deleteById(id);
    }

    // retrieve planets based on their type
    @GetMapping("/planets/type/{type}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'STUDENT')")
    public List<PlanetDTO> findPlanetsByType(@PathVariable String type) {
        return planetService.findByType(type);
    }

    // retrieve specific fields (name and mass) of all planets
    @GetMapping("/planets/fields")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'STUDENT')")
    public List<Object[]> getPlanetNamesAndMass() {
        return planetService.findPlanetNamesAndMassKg();
    }

    // add a new moon (ensuring planet really does exist)
    @PostMapping("/moons")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    @ResponseStatus(HttpStatus.CREATED)
    public MoonDTO addMoon(@Valid @RequestBody MoonDTO dto) {
        return moonService.addMoon(dto);
    }

    // retrieve all moons
    @GetMapping("/moons")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'STUDENT')")
    public List<MoonDTO> findAllMoons() {
        return moonService.findAll();
    }

    // retrieve a moon by its unique ID
    @GetMapping("/moons/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'STUDENT')")
    public MoonDTO findMoonById(@PathVariable int id) {
        return moonService.findById(id);
    }

    // remove a moon by its unique ID
    @DeleteMapping("/moons/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMoon(@PathVariable int id) {
        moonService.deleteById(id);
    }

    // list moons by planet name
    @GetMapping("/moons/planet/{planetName}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'STUDENT')")
    public List<MoonDTO> findMoonsByPlanetName(@PathVariable String planetName) {
        return moonService.findByPlanetName(planetName);
    }

    // count moons for a specific planet
    @GetMapping("/moons/count/planet/{planetName}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF', 'STUDENT')")
    public int countMoonsByPlanet(@PathVariable String planetName) {
        return moonService.countByPlanetName(planetName);
    }

}
