package com.ijse.lostandfoundsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String fullName;
    private String username;
    private String password;
    private String contactNumber;
    private String role;
    private Boolean isActive;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "reportedByUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> itemEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestEntity> requestEntityList = new ArrayList<>();
}