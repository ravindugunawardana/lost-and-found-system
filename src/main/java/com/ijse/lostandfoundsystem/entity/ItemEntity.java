package com.ijse.lostandfoundsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    private String itemName;
    private String description;
    private String itemStatus;
    private String locationLostOrFound;
    private LocalDate dateLostOrFound;
    private String category;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private UserEntity reportedByUser;

    @OneToMany(mappedBy = "itemEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestEntity> requestEntityList = new ArrayList<>();
}