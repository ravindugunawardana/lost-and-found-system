package com.ijse.lostandfoundsystem.service;

import com.ijse.lostandfoundsystem.dto.auth.AuthResponseDTO;
import com.ijse.lostandfoundsystem.dto.auth.SignInRequestDTO;
import com.ijse.lostandfoundsystem.dto.auth.SignUpRequestDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<String>  signUp(SignUpRequestDTO signUpRequestDTO);
    AuthResponseDTO signIn(SignInRequestDTO signInRequestDTO);
}