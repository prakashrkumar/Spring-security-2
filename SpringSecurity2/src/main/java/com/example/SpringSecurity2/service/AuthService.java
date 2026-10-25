package com.example.SpringSecurity2.service;

import com.example.SpringSecurity2.controller.RoleController;
import com.example.SpringSecurity2.dto.UserRegisterRequestDto;
import com.example.SpringSecurity2.dto.UserRegisterResponseDto;
import com.example.SpringSecurity2.entity.Role;
import com.example.SpringSecurity2.entity.User;
import com.example.SpringSecurity2.repository.RoleRepository;
import com.example.SpringSecurity2.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Service

public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;


    public AuthService(UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder){
       this.roleRepository=roleRepository;
    this.userRepository=userRepository;
    this.passwordEncoder=passwordEncoder;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto registerRequestDto){
        User user=new User();
        user.setUsername(registerRequestDto.getUsername());
        String encodePassword=passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassword(encodePassword);
        user.setEnable(true);
        Role role = roleRepository.findByName("Role_User").orElseGet(() -> {
            Role newRole = new Role();
            newRole.setName("Role_User");
            return roleRepository.save(newRole);
        });
        user.getRoles().add(role);


        userRepository.save(user);

        UserRegisterResponseDto responseDto =new UserRegisterResponseDto();
        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("User saved Successfully");

 return responseDto;

    }



}
