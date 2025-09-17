package com.olo.campusservice.application.usecase.campus_resource;

import com.olo.campusservice.domain.command.ModifyQuantityCommand;
import com.olo.campusservice.domain.exception.exists.CampusResourceNotFoundException;
import com.olo.campusservice.domain.exception.value.InvalidQuantityException;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.domain.port.inbound.campus_resource.ModifyCampusResourceQuantityPort;
import com.olo.campusservice.domain.port.outbound.CampusResourceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ModifyCampusResourceQuantityImpl implements ModifyCampusResourceQuantityPort {

    private final CampusResourceRepository campusResourceRepository;

    @Override
    public CampusResource modifyQuantity(ModifyQuantityCommand command) {
        CampusResource campusResource = campusResourceRepository.findById(command.id())
                .orElseThrow(() -> new CampusResourceNotFoundException("Campus resource not found"));

        if (command.quantity() <= 0){
            throw new InvalidQuantityException("Invalid quantity");
        }

        if (command.quantity() == campusResource.quantity()){
            return campusResource;
        }

        CampusResource updatedCampusResource = new CampusResource(
                campusResource.id(),
                campusResource.campus(),
                campusResource.resource(),
                command.quantity(),
                campusResource.state()
        );

        return campusResourceRepository.save(updatedCampusResource);
    }
}
