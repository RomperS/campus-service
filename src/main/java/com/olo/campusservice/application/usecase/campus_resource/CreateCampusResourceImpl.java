package com.olo.campusservice.application.usecase.campus_resource;

import com.olo.campusservice.domain.exception.exists.CampusNotFoundException;
import com.olo.campusservice.domain.exception.exists.CampusResourceExistsException;
import com.olo.campusservice.domain.exception.exists.ResourceNotFoundException;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.domain.port.inbound.campus_resource.CreateCampusResourcePort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import com.olo.campusservice.domain.port.outbound.CampusResourceRepository;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCampusResourceImpl implements CreateCampusResourcePort {

    private final CampusResourceRepository campusResourceRepository;
    private final ResourceRepository resourceRepository;
    private final CampusRepository campusRepository;

    @Override
    public CampusResource create(CampusResource campusResource) {
        if (!campusRepository.existsById(campusResource.campus().id())){
            throw new CampusNotFoundException("Campus not found");
        }
        if (!resourceRepository.existsById(campusResource.resource().id())){
            throw new ResourceNotFoundException("Resource not found");
        }
        if (campusResourceRepository.existsByCampusAndResourceAndState(
                campusResource.campus(),
                campusResource.resource(),
                campusResource.state())
        ) {
            throw new CampusResourceExistsException("Campus resource already exists");
        }

        CampusResource newCampusResource = new CampusResource(
                null,
                campusResource.campus(),
                campusResource.resource(),
                campusResource.quantity(),
                campusResource.state()
        );

        return campusResourceRepository.save(newCampusResource);
    }
}
