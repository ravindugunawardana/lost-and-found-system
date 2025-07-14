package com.ijse.lostandfoundsystem.service;

import com.ijse.lostandfoundsystem.dto.UserDTO;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);
    UserDTO getSelectedUser(Integer userId);
    List<UserDTO> getAllUsers();
    void updateUser(Integer userId, UserDTO userDTO);
    void deleteUser(Integer userId);
}
