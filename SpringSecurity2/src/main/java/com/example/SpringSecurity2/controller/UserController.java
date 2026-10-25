package com.example.SpringSecurity2.controller;

import com.example.SpringSecurity2.dto.UserRegisterRequestDto;
import com.example.SpringSecurity2.dto.UserRegisterResponseDto;
import com.example.SpringSecurity2.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/users")
public class UserController {
 private AuthService authService;
 public UserController(AuthService authService){
     this.authService=authService;
 }

    @GetMapping("/hello")
    public String sayHello(){


        return "hello bro";
    }
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto>register(@Valid @RequestBody UserRegisterRequestDto registerRequestDto){
    UserRegisterResponseDto userRegisterResponseDto= authService.register(registerRequestDto);
    return ResponseEntity.ok(userRegisterResponseDto);


    }
    @PostMapping("/login")
    public ResponseEntity<Boolean>loogin(@RequestBody UserRegisterRequestDto registerRequestDto){
     Boolean loggedIn=authService.login(registerRequestDto);
     return ResponseEntity.ok(loggedIn);
    }


    @GetMapping("/Token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }

}
