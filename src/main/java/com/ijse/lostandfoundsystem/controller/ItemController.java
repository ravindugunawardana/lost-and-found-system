package com.ijse.lostandfoundsystem.controller;

import com.ijse.lostandfoundsystem.dto.ItemDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    @GetMapping
    public String healthTest(){
        return "Item controller is running";
    }

    @PostMapping
    public ItemDTO reportLostItem(@RequestBody ItemDTO itemDTO){
        System.out.println(itemDTO);
        return itemDTO;
    }
}
