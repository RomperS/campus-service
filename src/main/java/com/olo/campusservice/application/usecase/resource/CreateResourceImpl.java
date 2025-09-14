package com.olo.campusservice.application.usecase.resource;

import com.olo.campusservice.domain.exception.exists.ResourceNameTakenException;
import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.port.inbound.resource.CreateResourcePort;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateResourceImpl implements CreateResourcePort {

    private final ResourceRepository resourceRepository;

    @Override
    public Resource create(Resource resource) {
        if (resourceRepository.existsByName(resource.name())){
            throw new ResourceNameTakenException("Resource name is already taken");
        }

        Resource newResource = new Resource(
                null,
                resource.name(),
                resource.supplierName(),
                resource.description()
        );

        return resourceRepository.save(newResource);
    }
}
