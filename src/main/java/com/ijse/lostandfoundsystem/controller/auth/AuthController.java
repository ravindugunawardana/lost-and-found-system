package com.ijse.lostandfoundsystem.controller.auth;

import com.ijse.lostandfoundsystem.dto.auth.AuthResponseDTO;
import com.ijse.lostandfoundsystem.dto.auth.SignInRequestDTO;
import com.ijse.lostandfoundsystem.dto.auth.SignUpRequestDTO;
import com.ijse.lostandfoundsystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO){
        authService.signUp(signUpRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/signIn")
    public ResponseEntity<AuthResponseDTO> signIn(@RequestBody SignInRequestDTO signInRequestDTO){
        authService.signIn(signInRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}