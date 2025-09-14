package com.olo.campusservice.application.usecase.campus_resource;

import com.olo.campusservice.domain.command.SearchCampusResourceCommand;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.domain.model.enums.State;
import com.olo.campusservice.domain.port.inbound.campus_resource.FindCampusResourcePort;
import com.olo.campusservice.domain.port.outbound.CampusResourceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FindCampusResourceImpl implements FindCampusResourcePort {

    private final CampusResourceRepository campusResourceRepository;

    @Override
    public List<CampusResource> find(SearchCampusResourceCommand command) {
        List<CampusResource> resources = campusResourceRepository.findAll();

        return resources.stream()
                .filter(r -> byId(command.id(), r))
                .filter(r -> byCampusId(command.campusId(), r))
                .filter(r -> byResourceId(command.resourceId(), r))
                .filter(r -> byQuantity(command.quantity(), r))
                .filter(r -> byState(command.state(), r))
                .toList();
    }

    private boolean byId(Long id, CampusResource resource) {
        if (id == null) return true;
        return id.equals(resource.id());
    }

    private boolean byCampusId(Long campusId, CampusResource resource) {
        if (campusId == null) return true;
        return campusId.equals(resource.campus().id());
    }

    private boolean byResourceId(Long resourceId, CampusResource resource) {
        if (resourceId == null) return true;
        return resourceId.equals(resource.resource().id());
    }

    private boolean byQuantity(int quantity, CampusResource resource) {
        if (quantity <= 0) return true;
        return resource.quantity() >= quantity;
    }

    private boolean byState(State state, CampusResource resource) {
        if (state == null) return true;

        return state.equals(resource.state());
    }
}

