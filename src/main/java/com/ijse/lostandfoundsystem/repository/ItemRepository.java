package com.ijse.lostandfoundsystem.repository;

import com.ijse.lostandfoundsystem.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    // Additional query methods can be defined here if needed
}
