package com.example.SpringSecurity2.controller;

import com.example.SpringSecurity2.dto.UserRegisterRequestDto;
import com.example.SpringSecurity2.dto.UserRegisterResponseDto;
import com.example.SpringSecurity2.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
 private AuthService authService;
 public UserController(AuthService authService){
     this.authService=authService;
 }

    @GetMapping({"/hello", "/users/hello"})
    public String sayHello(Authentication authentication){


        return "hello bro you are logg in as : "+ authentication.getName();
    }
    @PostMapping({"/users/register"})
    public ResponseEntity<UserRegisterResponseDto>register(@Valid @RequestBody UserRegisterRequestDto registerRequestDto){
    UserRegisterResponseDto userRegisterResponseDto= authService.register(registerRequestDto);
    return ResponseEntity.ok(userRegisterResponseDto);


    }





//    @GetMapping("/Token")
//    public CsrfToken getToken(CsrfToken csrfToken){
//        return csrfToken;
//    }
//
}
