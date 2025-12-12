package org.example.planet_project_manual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="moons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moonId;
    @Column(nullable=false, unique=true)

    private String name;

    private int diameterKm;

    private int orbitalPeriodDays;

    @ManyToOne(fetch = FetchType.EAGER) // many moons can belong to one planet

    @JoinColumn(name = "planet_id") // foreign key
    private Planet planet;
}