package com.ijse.lostandfoundsystem.service.impl;

import com.ijse.lostandfoundsystem.dto.UserDTO;
import com.ijse.lostandfoundsystem.entity.UserEntity;
import com.ijse.lostandfoundsystem.repository.UserRepository;
import com.ijse.lostandfoundsystem.service.UserService;
import com.ijse.lostandfoundsystem.util.EntityDTOConversion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EntityDTOConversion entityDTOConversion;

    @Override
    public void createUser(UserDTO userDTO) {
        UserEntity userEntity = userRepository.save(entityDTOConversion.toUserEntity(userDTO));
        System.out.println("Saved user: "+ userEntity);
    }

    @Override
    public UserDTO getSelectedUser(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        return entityDTOConversion.toUserDTO(userEntity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return entityDTOConversion.toUserDTOList(userEntityList);
    }

    @Override
    public void updateUser(Integer userId, UserDTO userDTO) {
        UserEntity existingUserEntity = userRepository.findById(userId).orElseThrow();

        existingUserEntity.setFullName(userDTO.getFullName());
        existingUserEntity.setUsername(userDTO.getUsername());
        existingUserEntity.setPassword(userDTO.getPassword());
        existingUserEntity.setContactNumber(userDTO.getContactNumber());
        existingUserEntity.setRole(userDTO.getRole());
        existingUserEntity.setIsActive(userDTO.getIsActive());
        existingUserEntity.setCreatedAt(userDTO.getCreatedAt());

        userRepository.save(existingUserEntity);
    }

    @Override
    public void deleteUser(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        userRepository.deleteById(userId);
    }
}