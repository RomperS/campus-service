package com.olo.campusservice.application.usecase.resource;

import com.olo.campusservice.domain.port.inbound.resource.DeleteResourcePort;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteResourceImpl implements DeleteResourcePort {

    private final ResourceRepository resourceRepository;

    @Override
    public void delete(Long id) {
        resourceRepository.delete(id);
    }
}
