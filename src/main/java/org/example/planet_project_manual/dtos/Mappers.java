package org.example.planet_project_manual.dtos;

import org.example.planet_project_manual.entities.Moon;
import org.example.planet_project_manual.entities.MyUser;
import org.example.planet_project_manual.entities.Planet;

import java.util.List;

public class Mappers {

    public static PlanetDTO mapPlanetToPlanetDTO(Planet p){
        List<MoonDTO> moonDTOs =
                p.getMoons()
                        .stream()
                        .map(Mappers::mapMoonToMoonDTONoPlanet)
                        .toList();
        return new PlanetDTO(
                p.getPlanetId(),
                p.getName(),
                p.getType(),
                p.getRadiusKm(),
                p.getMassKg(),
                p.getOrbitalPeriodDays(),
                moonDTOs
        );
    }

    public static Planet mapPlanetDTOToPlanet(PlanetDTO dto) {
        Planet p = new Planet();
        p.setPlanetId(dto.planetId());
        p.setName(dto.name());
        p.setType(dto.type());
        p.setRadiusKm(dto.radiusKm());
        p.setMassKg(dto.massKg());
        p.setOrbitalPeriodDays(dto.orbitalPeriodDays());
        return p;
    }


    public static MoonDTO mapMoonToMoonDTONoPlanet(Moon m){
        return new MoonDTO(
                m.getMoonId(),
                m.getName(),
                m.getDiameterKm(),
                m.getOrbitalPeriodDays(),
                null
        );
    }


    public static MoonDTO mapMoonToMoonDTO(Moon m){
        return new MoonDTO(
                m.getMoonId(),
                m.getName(),
                m.getDiameterKm(),
                m.getOrbitalPeriodDays(),
                m.getPlanet() != null ?
                        new PlanetDTO(m.getPlanet().getPlanetId(), m.getPlanet().getName(), m.getPlanet().getType(), m.getPlanet().getRadiusKm(), m.getPlanet().getMassKg(), m.getPlanet().getOrbitalPeriodDays(), null)
                        : null
        );
    }

    public static Moon mapMoonDTOToMoon(MoonDTO dto, Planet planet){
        Moon m = new Moon();
        m.setMoonId(dto.moonId());
        m.setName(dto.name());
        m.setDiameterKm(dto.diameterKm());
        m.setOrbitalPeriodDays(dto.orbitalPeriodDays());
        m.setPlanet(planet);
        return m;
    }

    public static MyUserDTO mapMyUserToDTO(MyUser user) {
        if (user == null) return null;
        return new MyUserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getRole().name(),
                user.isEnabled(),
                user.isUnlocked(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }


    public static MyUser mapNewUserDTOToMyUser(NewUserDTO dto) {
        MyUser user = new MyUser();
        user.setUsername(dto.username());
        user.setPassword(dto.password());
        user.setRole(MyUser.Role.valueOf(dto.role().toUpperCase()));
        user.setEnabled(true);
        user.setUnlocked(true);
        return user;
    }
}
