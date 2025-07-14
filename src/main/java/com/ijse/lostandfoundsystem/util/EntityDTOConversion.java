package com.ijse.lostandfoundsystem.util;

import com.ijse.lostandfoundsystem.dto.ItemDTO;
import com.ijse.lostandfoundsystem.dto.RequestDTO;
import com.ijse.lostandfoundsystem.dto.UserDTO;
import com.ijse.lostandfoundsystem.entity.ItemEntity;
import com.ijse.lostandfoundsystem.entity.RequestEntity;
import com.ijse.lostandfoundsystem.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDTOConversion {
    private final ModelMapper modelMapper;

    //Item
    public ItemDTO toItemDTO(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public List<ItemDTO> toItemDTOList(List<ItemEntity> itemEntityList){
        return modelMapper.map(itemEntityList,new TypeToken<List<ItemDTO>>(){}.getType());
    }

    //Request
    public RequestDTO toRequestDTO(RequestEntity requestEntity){
        return modelMapper.map(requestEntity, RequestDTO.class);
    }

    public RequestEntity toRequestEntity(RequestDTO requestDTO){
        return modelMapper.map(requestDTO, RequestEntity.class);
    }

    public List<RequestDTO> toRequestDTOList(List<RequestEntity> requestEntityList){
        return modelMapper.map(requestEntityList, new TypeToken<List<RequestDTO>>(){}.getType());
    }

    //User
    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public List<UserDTO> toUserDTOList(List<UserEntity> userEntityList){
        return modelMapper.map(userEntityList, new TypeToken<List<UserDTO>>(){}.getType());
    }
}
