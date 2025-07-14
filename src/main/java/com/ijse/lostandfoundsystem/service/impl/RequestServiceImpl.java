package com.ijse.lostandfoundsystem.service.impl;

import com.ijse.lostandfoundsystem.dto.RequestDTO;
import com.ijse.lostandfoundsystem.entity.RequestEntity;
import com.ijse.lostandfoundsystem.repository.RequestRepository;
import com.ijse.lostandfoundsystem.service.RequestService;
import com.ijse.lostandfoundsystem.util.EntityDTOConversion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    private final EntityDTOConversion entityDTOConversion;

    @Override
    public void createRequest(RequestDTO requestDTO) {
        RequestEntity requestEntity = requestRepository.save(entityDTOConversion.toRequestEntity(requestDTO));
        System.out.println("Saved request: "+ requestEntity);
    }
    @Override
    public RequestDTO getSelectedRequest(Integer requestId) {
        RequestEntity requestEntity = requestRepository.findById(requestId).orElseThrow();
        return entityDTOConversion.toRequestDTO(requestEntity);
    }

    @Override
    public List<RequestDTO> getAllRequests() {
        List<RequestEntity> requestEntityList =  requestRepository.findAll();
        return entityDTOConversion.toRequestDTOList(requestEntityList);
    }

    @Override
    public void updateRequest(Integer requestId, RequestDTO requestDTO) {
        RequestEntity existingRequestEntity = requestRepository.findById(requestId).orElseThrow();

        existingRequestEntity.setClaimingItemId(requestDTO.getClaimingItemId());
        existingRequestEntity.setClaimerId(requestDTO.getClaimerId());
        existingRequestEntity.setItemDescription(requestDTO.getItemDescription());
        existingRequestEntity.setRequestStatus(requestDTO.getRequestStatus());
        existingRequestEntity.setLostDate(requestDTO.getLostDate());
        existingRequestEntity.setLostLocation(requestDTO.getLostLocation());

        requestRepository.save(existingRequestEntity);
    }

    @Override
    public void deleteRequest(Integer requestId) {
        RequestEntity requestEntity = requestRepository.findById(requestId).orElseThrow();
        requestRepository.deleteById(requestId);
    }
}