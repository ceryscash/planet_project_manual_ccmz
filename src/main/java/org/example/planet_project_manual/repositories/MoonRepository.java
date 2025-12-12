package org.example.planet_project_manual.repositories;

import org.example.planet_project_manual.entities.Moon;
import org.example.planet_project_manual.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoonRepository extends JpaRepository<Moon, Integer> {

    // retrieve all moons for a specific planet by name
    @Query("SELECT m FROM Moon m WHERE m.planet.name = :planetName")
    List<Moon> findByPlanetName(@Param("planetName") String planetName);

    // count moons for a specific planet by name
    @Query("SELECT COUNT(m) FROM Moon m WHERE m.planet.name = :planetName")
    int countByPlanetName(@Param("planetName") String planetName);
}
