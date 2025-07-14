package com.ijse.lostandfoundsystem.repository;

import com.ijse.lostandfoundsystem.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestEntity, Integer> {}
