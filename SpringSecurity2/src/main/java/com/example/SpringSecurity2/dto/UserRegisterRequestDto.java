package com.example.SpringSecurity2.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonAlias;

@Getter
@Setter
public class UserRegisterRequestDto {
    @NotBlank(message = "Username is required")
    @JsonAlias("name")
    private String username;
    @NotBlank(message = "Password is required")
    private  String password;
}
