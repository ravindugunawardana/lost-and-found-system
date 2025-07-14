package com.ijse.lostandfoundsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDTO implements Serializable {
    private Integer id;

    private Integer claimingItemId;
    private String claimerId;
    private String itemDescription;
    private String  requestStatus;
    private Date lostDate;
    private String lostLocation;
}