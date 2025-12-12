package org.example.planet_project_manual.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.planet_project_manual.dtos.MoonDTO;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MoonAspects {

    @Pointcut("execution(* org.example.planet_project_manual.services.MoonServiceImplementation.addMoon(..)) && args(dto)")
    public void createMoon(MoonDTO dto) {}

    @Before("createMoon(dto)")
    public void beforeCreateMoon(JoinPoint joinPoint, MoonDTO dto) {
        log.info("✅ Before creating moon: {} for planet: {}", dto.name(), dto.planet() != null ? dto.planet().name() : "unknown");
    }

    @AfterReturning(value = "createMoon(dto)", returning = "returned")
    public void afterCreateMoon(JoinPoint joinPoint, MoonDTO dto, Object returned) {
        log.info("✅ After creating moon: {} Result: {}", dto.name(), returned);
    }


    @Pointcut("execution(* org.example.planet_project_manual.services.MoonServiceImplementation.findById(..)) && args(id)")
    public void findMoon(int id) {}

    @Before("findMoon(id)")
    public void beforeFindMoon(JoinPoint joinPoint, int id) {
        log.info("🔍 Before finding moon with id: {}", id);
    }

    @AfterReturning(value = "findMoon(id)", returning = "returned")
    public void afterFindMoon(JoinPoint joinPoint, int id, Object returned) {
        log.info("🔍 After finding moon with id: {} Result: {}", id, returned);
    }


    @Pointcut("execution(* org.example.planet_project_manual.services.MoonServiceImplementation.deleteById(..)) && args(id)")
    public void deleteMoon(int id) {}

    @Before("deleteMoon(id)")
    public void beforeDeleteMoon(JoinPoint joinPoint, int id) {
        log.info("❌ Before deleting moon with id: {}", id);
    }

    @After("deleteMoon(id)")
    public void afterDeleteMoon(JoinPoint joinPoint, int id) {
        log.info("❌ After deleting moon with id: {}", id);
    }

}
