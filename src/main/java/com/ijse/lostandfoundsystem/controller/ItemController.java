package com.ijse.lostandfoundsystem.controller;

import com.ijse.lostandfoundsystem.dto.ItemDTO;
import com.ijse.lostandfoundsystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @GetMapping
    public String healthTest(){
        return "Item controller is running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> reportItem(@RequestBody ItemDTO itemDTO){
        itemService.reportItem(itemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDTO> getSelectedItem(@PathVariable Integer itemId){
        return ResponseEntity.ok(itemService.getSelectedItem(itemId));
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @PatchMapping
    public ResponseEntity<Void> updateItem(@RequestParam ("itemId") Integer itemId, @RequestBody ItemDTO itemDTO){
        itemService.updateItem(itemId, itemDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteItem(@RequestParam ("itemId") Integer itemId){
        itemService.deleteItem(itemId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
