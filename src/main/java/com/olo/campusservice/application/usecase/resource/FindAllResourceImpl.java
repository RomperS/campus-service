package com.olo.campusservice.application.usecase.resource;

import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.port.inbound.resource.FindAllResourcePort;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllResourceImpl implements FindAllResourcePort {

    private final ResourceRepository resourceRepository;

    @Override
    public List<Resource> findAll() {
        return resourceRepository.findAll();
    }
}
