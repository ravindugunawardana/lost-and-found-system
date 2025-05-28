package com.ijse.lostandfoundsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements Serializable {
    private Long id;
    private String itemName;
    private String description;
    private String itemStatus;
}