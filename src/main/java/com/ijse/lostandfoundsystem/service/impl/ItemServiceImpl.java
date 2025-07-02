package com.ijse.lostandfoundsystem.service.impl;

import com.ijse.lostandfoundsystem.dto.ItemDTO;
import com.ijse.lostandfoundsystem.repository.ItemRepository;
import com.ijse.lostandfoundsystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void reportItem(ItemDTO itemDTO) {

    }

    @Override
    public ItemDTO getSelectedItem(Long itemId) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return null;
    }

    @Override
    public void updateItem(Long itemId, ItemDTO itemDTO) {

    }

    @Override
    public void deleteItem(Long itemId) {

    }
}
