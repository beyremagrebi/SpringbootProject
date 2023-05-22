package com.project.demandes.gestiondemandes.service;

import com.project.demandes.gestiondemandes.dao.RoleRepository;
import com.project.demandes.gestiondemandes.dao.UserRepository;
import com.project.demandes.gestiondemandes.entities.Role;
import com.project.demandes.gestiondemandes.entities.User;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;



    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder=new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        Objects.requireNonNull(username);
        User user = userRepository.findUserWithName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    public User saveUser(String username, String password, String confirmedPassword) {
        User appUser = new User();
        if (userRepository.findUserWithName(username).isPresent() == true)
            throw new RuntimeException("User already exists");
        if (!password.equals(confirmedPassword))
            throw new RuntimeException("Please confirm your password");
        appUser.setUsername(username);
        Set<Role> roles = new HashSet<Role>();
        Role r = new Role("ROLE_USER");
        roleRepository.save(r);
        roles.add(r);
        appUser.setRoles(roles);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(appUser);
        return appUser;
    }

}
