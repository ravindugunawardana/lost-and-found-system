package com.ijse.lostandfoundsystem.controller;

import com.ijse.lostandfoundsystem.dto.RequestDTO;
import com.ijse.lostandfoundsystem.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public String healthTest(){
        return "Request controller is running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRequest(@RequestBody RequestDTO requestDTO){
        requestService.createRequest(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "{requestId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequestDTO> getSelectedRequest(@PathVariable Integer requestId){
        return ResponseEntity.ok(requestService.getSelectedRequest(requestId));
    }

    @GetMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RequestDTO>> getAlRequests(){
        return ResponseEntity.ok(requestService.getAllRequests());
    }

    @PatchMapping
    public ResponseEntity<Void> updateRequest(@RequestParam ("requestId") Integer requestId, @RequestBody RequestDTO requestDTO){
        requestService.updateRequest(requestId, requestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteRequest(@RequestParam ("requestId") Integer requestId){
        requestService.deleteRequest(requestId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
