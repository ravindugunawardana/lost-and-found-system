package com.ijse.lostandfoundsystem.controller;

import com.ijse.lostandfoundsystem.dto.UserDTO;
import com.ijse.lostandfoundsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String UserHealthTest(){
        return "User controller is running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedUser(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getSelectedUser(userId));
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestParam ("userId") Integer userId, @RequestBody UserDTO userDTO){
        userService.updateUser(userId, userDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam ("userId") Integer userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
