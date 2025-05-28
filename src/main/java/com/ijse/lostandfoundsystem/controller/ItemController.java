package com.ijse.lostandfoundsystem.controller;

import com.ijse.lostandfoundsystem.dto.ItemDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    @GetMapping
    public String healthTest(){
        return "Item controller is running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDTO reportLostItem(@RequestBody ItemDTO itemDTO){
        System.out.println(itemDTO);
        return itemDTO;
    }
}
