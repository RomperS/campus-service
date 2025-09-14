package com.olo.campusservice.application.usecase.resource;

import com.olo.campusservice.domain.exception.exists.ResourceNameTakenException;
import com.olo.campusservice.domain.exception.exists.ResourceNotFoundException;
import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.port.inbound.resource.UpdateResourcePort;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateResourceImpl implements UpdateResourcePort {

    private final ResourceRepository resourceRepository;

    @Override
    public Resource update(Resource resource) {
        Resource targetResource = resourceRepository.findById(resource.id()).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));

        String name = targetResource.name();
        if (resource.name() != null && !resource.name().equals(name)) {
            if (resourceRepository.existsByName(name)) {
                throw new ResourceNameTakenException("Resource name is already taken");
            }
            name = resource.name();
        }

        String supplierName = targetResource.supplierName();
        if (resource.supplierName() != null && !resource.supplierName().equals(supplierName)) {
            supplierName = resource.supplierName();
        }

        String description = targetResource.description();
        if (resource.description() != null && !resource.description().equals(description)) {
            description = resource.description();
        }

        Resource updatedResource = new Resource(
                targetResource.id(),
                name,
                supplierName,
                description
        );

        return resourceRepository.save(updatedResource);
    }
}
