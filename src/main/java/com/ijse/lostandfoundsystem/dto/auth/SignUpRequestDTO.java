package com.ijse.lostandfoundsystem.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpRequestDTO {
    private String fullName;
    private String username;
    private String password;
    private String contactNumber;
    private String role;
}