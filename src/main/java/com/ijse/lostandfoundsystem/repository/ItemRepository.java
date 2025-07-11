package com.ijse.lostandfoundsystem.repository;

import com.ijse.lostandfoundsystem.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    // Additional query methods can be defined here if needed
}
