package com.olo.campusservice.application.usecase.campus_resource;

import com.olo.campusservice.domain.command.CampusResourceCommand;
import com.olo.campusservice.domain.exception.exists.CampusNotFoundException;
import com.olo.campusservice.domain.exception.exists.CampusResourceExistsException;
import com.olo.campusservice.domain.exception.exists.ResourceNotFoundException;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.domain.model.Resource;
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
    public CampusResource create(CampusResourceCommand command) {
        Campus campus = campusRepository.findById(command.campusId()).orElseThrow(() -> new CampusNotFoundException("Campus not found"));
        Resource resource = resourceRepository.findById(command.resourceId()).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));

        if (campusResourceRepository.existsByCampusAndResourceAndState(campus, resource, command.state())) {
            throw new CampusResourceExistsException("Campus resource already exists");
        }

        CampusResource newCampusResource = new CampusResource(
                null,
                campus,
                resource,
                command.quantity(),
                command.state()
        );

        return campusResourceRepository.save(newCampusResource);
    }
}
