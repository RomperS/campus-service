package com.olo.campusservice.application.usecase.resource;

import com.olo.campusservice.domain.exception.exists.ResourceNotFoundException;
import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.port.inbound.resource.FindResourceByIdPort;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindResourceByIdImpl implements FindResourceByIdPort {

    private final ResourceRepository resourceRepository;

    @Override
    public Resource findById(Long id) {
        return resourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }
}
