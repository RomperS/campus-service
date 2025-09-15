package com.olo.campusservice.domain.port.outbound;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.model.enums.State;

import java.util.List;
import java.util.Optional;

public interface CampusResourceRepository {
    boolean existsByCampusAndResourceAndState(Campus campus, Resource resource, State state);

    CampusResource save(CampusResource campusResource);

    List<CampusResource> findAll();
    Optional<CampusResource> findById(Long id);

    void delete(Long id);
}
