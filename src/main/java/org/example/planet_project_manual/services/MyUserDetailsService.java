package org.example.planet_project_manual.services;

import lombok.AllArgsConstructor;
import org.example.planet_project_manual.entities.MyUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private MyUserService myUserService;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserService.getMyUser(username);

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + myUser.getRole().name());
        return new User(
                myUser.getUsername(),
                myUser.getPassword(),
                myUser.isEnabled(),
                true,
                true,
                myUser.isUnlocked(),
                Collections.singletonList(authority));
    }
}