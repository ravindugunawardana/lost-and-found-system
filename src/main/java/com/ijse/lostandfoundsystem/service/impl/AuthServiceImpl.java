package com.ijse.lostandfoundsystem.service.impl;

import com.ijse.lostandfoundsystem.dto.auth.AuthResponseDTO;
import com.ijse.lostandfoundsystem.dto.auth.SignInRequestDTO;
import com.ijse.lostandfoundsystem.dto.auth.SignUpRequestDTO;
import com.ijse.lostandfoundsystem.entity.UserEntity;
import com.ijse.lostandfoundsystem.repository.UserRepository;
import com.ijse.lostandfoundsystem.security.JwtUtils;
import com.ijse.lostandfoundsystem.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String>  signUp(SignUpRequestDTO signUpRequestDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(signUpRequestDTO.getFullName());
        userEntity.setUsername(signUpRequestDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(signUpRequestDTO.getPassword()));
        userEntity.setContactNumber(signUpRequestDTO.getContactNumber());
        userEntity.setRole(signUpRequestDTO.getRole());
        userEntity.setIsActive(true);
        userRepository.save(userEntity);
        return ResponseEntity.ok("User successfully registered");
}
    @Override
    public AuthResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequestDTO.getUsername(),
                        signInRequestDTO.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtils.generateTokens(userDetails);
        return AuthResponseDTO.builder().token(token).build();
    }
}
