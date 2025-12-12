package org.example.planet_project_manual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="planets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planetId;
    @Column(nullable=false, unique=true)

    private String name;

    private String type;

    private int radiusKm;

    private int massKg;

    private int orbitalPeriodDays;

    @OneToMany(mappedBy = "planet",  fetch = FetchType.EAGER)
    private List<Moon> moons;

}