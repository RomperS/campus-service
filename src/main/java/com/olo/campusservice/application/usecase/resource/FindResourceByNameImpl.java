package com.olo.campusservice.application.usecase.resource;

import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.port.inbound.resource.FindResourceByNamePort;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindResourceByNameImpl implements FindResourceByNamePort {

    private final ResourceRepository resourceRepository;

    @Override
    public List<Resource> findByName(String name) {
        return resourceRepository.findByName(name);
    }
}
