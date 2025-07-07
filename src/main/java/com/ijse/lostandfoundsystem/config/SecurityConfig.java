package com.ijse.lostandfoundsystem.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for testing APIs via Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/items/**").permitAll() // Allow item-related endpoints
                        .anyRequest().authenticated() // Secure everything else
                )
                .httpBasic(Customizer.withDefaults()); // Basic auth, or remove for none

        return http.build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
