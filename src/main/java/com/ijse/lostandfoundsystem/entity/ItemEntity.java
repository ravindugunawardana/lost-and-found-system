package com.ijse.lostandfoundsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String itemName;
    private String description;
    private String itemStatus;
    private String locationLostOrFound;
    private LocalDate dateLostOrFound;
    private String category;
    private Integer reportedByUserId;
}