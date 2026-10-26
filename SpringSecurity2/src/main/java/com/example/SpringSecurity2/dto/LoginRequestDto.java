package com.example.SpringSecurity2.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    @JsonAlias("name")
    private String username;
    private String password;
}
