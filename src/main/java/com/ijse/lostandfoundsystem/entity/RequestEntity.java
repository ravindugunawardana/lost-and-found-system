package com.ijse.lostandfoundsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;

    private Integer claimingItemId;
    private String claimerId;
    private String itemDescription;
    private String  requestStatus;
    private Date lostDate;
    private String lostLocation;

    @ManyToOne()
    @JoinColumn(name = "itemId", nullable = false)
    private ItemEntity itemEntity;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity userEntity;
}