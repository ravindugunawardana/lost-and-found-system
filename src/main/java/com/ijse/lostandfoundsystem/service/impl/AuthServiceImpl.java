package com.ijse.lostandfoundsystem.service.impl;

import com.ijse.lostandfoundsystem.dto.UserDTO;
import com.ijse.lostandfoundsystem.dto.auth.AuthResponseDTO;
import com.ijse.lostandfoundsystem.dto.auth.SignInRequestDTO;
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

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setContactNumber(userDTO.getContactNumber());
        userEntity.setRole(userDTO.getRole());
        userEntity.setIsActive(true);
        userRepository.save(userEntity);
        ResponseEntity.ok("User successfully registered");
    }

    @Override
    public AuthResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequestDTO.getUsername(),
                        signInRequestDTO.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtils.generateTokens(userDetails);
        return AuthResponseDTO.builder().accessToken(token).build();
    }
}
