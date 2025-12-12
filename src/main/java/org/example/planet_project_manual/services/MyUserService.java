package org.example.planet_project_manual.services;

import org.example.planet_project_manual.dtos.MyUserDTO;
import org.example.planet_project_manual.dtos.NewUserDTO;
import org.example.planet_project_manual.entities.MyUser;
import org.springframework.expression.spel.ast.OpMultiply;

public interface MyUserService {
    MyUser getMyUser(String username);
    MyUserDTO findById(int id);
    MyUserDTO createUser(NewUserDTO dto);
}