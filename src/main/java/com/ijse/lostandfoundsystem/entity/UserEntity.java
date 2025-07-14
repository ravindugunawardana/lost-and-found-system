package com.ijse.lostandfoundsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String fullName;
    private String username;
    private String password;
    private String contactNumber;
    private String role;
    private Boolean isActive;
    private LocalDateTime createdAt;
}