package com.ijse.lostandfoundsystem.service;

import com.ijse.lostandfoundsystem.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void reportItem(ItemDTO itemDTO);
    ItemDTO getSelectedItem(Integer itemId);
    List<ItemDTO> getAllItems();
    void updateItem(Integer itemId, ItemDTO itemDTO);
    void deleteItem(Integer itemId);
}
