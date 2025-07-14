package com.ijse.lostandfoundsystem.repository;

import com.ijse.lostandfoundsystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
