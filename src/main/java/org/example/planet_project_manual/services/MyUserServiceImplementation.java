package org.example.planet_project_manual.services;

import lombok.AllArgsConstructor;
import org.example.planet_project_manual.dtos.MyUserDTO;
import org.example.planet_project_manual.dtos.NewUserDTO;
import org.example.planet_project_manual.dtos.Mappers;
import org.example.planet_project_manual.entities.MyUser;
import org.example.planet_project_manual.repositories.MyUserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserServiceImplementation implements MyUserService {

    private final MyUserRepository myUserRepository;

    @Override
    public MyUser getMyUser(String username) {
        return myUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Override
    public MyUserDTO findById(int id) {
        MyUser user = myUserRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        return Mappers.mapMyUserToDTO(user);
    }

    @Override
    public MyUserDTO createUser(NewUserDTO dto) {
        MyUser user = Mappers.mapNewUserDTOToMyUser(dto);
        MyUser saved = myUserRepository.save(user);
        return Mappers.mapMyUserToDTO(saved);
    }
}
