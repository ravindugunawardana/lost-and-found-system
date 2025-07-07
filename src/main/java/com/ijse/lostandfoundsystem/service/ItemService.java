package com.ijse.lostandfoundsystem.service;

import com.ijse.lostandfoundsystem.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void reportItem(ItemDTO itemDTO);
    ItemDTO getSelectedItem(int itemId);
    List<ItemDTO> getAllItems();
    void updateItem(Long itemId, ItemDTO itemDTO);
    void deleteItem(Long itemId);
}
