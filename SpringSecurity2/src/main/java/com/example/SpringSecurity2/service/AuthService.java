package com.example.SpringSecurity2.service;

import com.example.SpringSecurity2.dto.UserRegisterRequestDto;
import com.example.SpringSecurity2.dto.UserRegisterResponseDto;
import com.example.SpringSecurity2.entity.User;
import com.example.SpringSecurity2.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Service

public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository){

        this.userRepository=userRepository;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto registerRequestDto){
        User user=new User();
        user.setUsername(registerRequestDto.getUsername());
        String encodePassword=passwordEncoder.encode(registerRequestDto.getPassword());
        user.setPassword(encodePassword);
        user.setEnable(true);

        userRepository.save(user);

        UserRegisterResponseDto responseDto =new UserRegisterResponseDto();
        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("User saved Successfully");

 return responseDto;

    }
    public  Boolean login(UserRegisterRequestDto registerRequestDto){
        Optional<User>userOptional=userRepository.findByUsername(registerRequestDto.getUsername());
        User user=userOptional.get();
        String encodePassword=user.getPassword();
      return  passwordEncoder.matches(registerRequestDto.getPassword(),encodePassword);
    }


}
