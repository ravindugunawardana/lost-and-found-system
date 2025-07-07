package com.ijse.lostandfoundsystem.util;

import java.util.UUID;

public class UtilityData {
    public static String generateItemId(){
        return "B-"+ UUID.randomUUID();
    }
}
