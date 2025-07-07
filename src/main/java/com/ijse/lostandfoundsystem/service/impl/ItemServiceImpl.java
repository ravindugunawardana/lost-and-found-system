package com.ijse.lostandfoundsystem.service.impl;

import com.ijse.lostandfoundsystem.dto.ItemDTO;
import com.ijse.lostandfoundsystem.entity.ItemEntity;
import com.ijse.lostandfoundsystem.repository.ItemRepository;
import com.ijse.lostandfoundsystem.service.ItemService;
import com.ijse.lostandfoundsystem.util.EntityDTOConversion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
        ItemEntity itemEntity = itemRepository.save(entityDTOConversion.toItemEntity(itemDTO));
        System.out.println("Saved item: "+ itemEntity);
    }

    @Override
    public ItemDTO getSelectedItem(Integer itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow();
        return entityDTOConversion.toItemDTO(itemRepository.getReferenceById(itemId));
    }
    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> itemEntityList = itemRepository.findAll();
        return entityDTOConversion.toItemDTOList(itemEntityList);
    }

    @Override
    public void updateItem(Integer itemId, ItemDTO itemDTO) {
        ItemEntity existingEntity = itemRepository.findById(itemId).orElseThrow();

        existingEntity.setItemName(itemDTO.getItemName());
        existingEntity.setDescription(itemDTO.getDescription());
        existingEntity.setItemStatus(itemDTO.getItemStatus());

        itemRepository.save(existingEntity);
    }

    @Override
    public void deleteItem(Integer itemId) {
        ItemEntity existingEntity = itemRepository.findById(itemId).orElseThrow();
        itemRepository.deleteById(itemId);

    }
}
