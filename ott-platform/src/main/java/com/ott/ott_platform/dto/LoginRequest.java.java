package com.ott.platform.dto;

import lombok.Data;

@Data // Lombok: Generates getters, setters, etc.
public class LoginRequest {
    private String username;
    private String password;
}