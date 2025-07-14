package com.ijse.lostandfoundsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Integer Id;
    private String fullName;
    private String username;
    private String password;
    private String contactNumber;
    private String role;
    private Boolean isActive;
    private LocalDateTime createdAt;
}