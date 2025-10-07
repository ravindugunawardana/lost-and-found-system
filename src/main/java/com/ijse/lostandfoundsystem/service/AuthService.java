package com.ijse.lostandfoundsystem.service;

import com.ijse.lostandfoundsystem.dto.UserDTO;
import com.ijse.lostandfoundsystem.dto.auth.AuthResponseDTO;
import com.ijse.lostandfoundsystem.dto.auth.SignInRequestDTO;

public interface AuthService {
    void signUp(UserDTO userDTO);
    AuthResponseDTO signIn(SignInRequestDTO signInRequestDTO);
}