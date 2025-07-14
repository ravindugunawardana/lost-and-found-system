package com.ijse.lostandfoundsystem.service;

import com.ijse.lostandfoundsystem.dto.RequestDTO;

import java.util.List;

public interface RequestService {
    void createRequest(RequestDTO requestDTO);
    RequestDTO getSelectedRequest(Integer requestId);
    List<RequestDTO> getAllRequests();
    void updateRequest(Integer requestId, RequestDTO requestDTO);
    void deleteRequest(Integer requestId);
}
