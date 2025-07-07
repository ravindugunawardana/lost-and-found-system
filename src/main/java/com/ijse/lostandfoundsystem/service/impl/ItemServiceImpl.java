package com.ijse.lostandfoundsystem.service.impl;

import com.ijse.lostandfoundsystem.dto.ItemDTO;
import com.ijse.lostandfoundsystem.entity.ItemEntity;
import com.ijse.lostandfoundsystem.repository.ItemRepository;
import com.ijse.lostandfoundsystem.service.ItemService;
import com.ijse.lostandfoundsystem.util.EntityDTOConversion;
import com.ijse.lostandfoundsystem.util.UtilityData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    
    private final ItemRepository itemRepository;

    private final EntityDTOConversion entityDTOConversion;

    @Override
    public void reportItem(ItemDTO itemDTO) {
        //itemDTO.setId(UtilityData.generateItemId());
        ItemEntity itemEntity = itemRepository.save(entityDTOConversion.toItemEntity(itemDTO));
        System.out.println("Saved item: "+ itemEntity);
    }

    @Override
    public ItemDTO getSelectedItem(int itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow();
        return entityDTOConversion.toItemDTO(itemRepository.getReferenceById(itemId));
    }
    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> itemEntityList = itemRepository.findAll();
        return entityDTOConversion.toItemDTOList(itemEntityList);
    }

    @Override
    public void updateItem(Long itemId, ItemDTO itemDTO) {

    }

    @Override
    public void deleteItem(Long itemId) {

    }
}
