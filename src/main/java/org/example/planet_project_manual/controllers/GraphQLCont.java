package org.example.planet_project_manual.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.planet_project_manual.dtos.MyUserDTO;
import org.example.planet_project_manual.dtos.NewUserDTO;
import org.example.planet_project_manual.dtos.MyUserDTO;
import org.example.planet_project_manual.services.MyUserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GraphQLCont {

    private final MyUserService myUserService;


    @QueryMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MyUserDTO getUserById(@Argument int id) {
        return myUserService.findById(id);
    }

    @MutationMapping
    @PreAuthorize("hasRole('ADMIN')")
    public MyUserDTO createUser(@Valid @Argument("newUser") NewUserDTO newUserDTO) {
        return myUserService.createUser(newUserDTO);
    }
}
