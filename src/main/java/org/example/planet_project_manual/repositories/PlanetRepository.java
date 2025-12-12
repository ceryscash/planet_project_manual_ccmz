package org.example.planet_project_manual.repositories;

import org.example.planet_project_manual.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet,Integer> {

    // update the details of an existing planet - changing mass val
    @Modifying
    @Transactional
    @Query("UPDATE Planet p SET p.massKg = :massKg WHERE p.planetId = :id")
    int updateMassById(@Param("id") int id, @Param("massKg") Double massKg);

    // retrieve based on type
    @Query("SELECT p FROM Planet p WHERE p.type = :type")
    List<Planet> findByType(@Param("type") String type);

    // retrieve specific fields of a planet - name and mass
    @Query("SELECT p.name, p.massKg FROM Planet p WHERE p.name IS NOT NULL")
    List<Object[]> findPlanetNamesAndMassKg();
}
