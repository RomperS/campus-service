package com.olo.campusservice.application.usecase.campus_resource;

import com.olo.campusservice.domain.port.inbound.campus_resource.DeleteCampusResourcePort;
import com.olo.campusservice.domain.port.outbound.CampusResourceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCampusResourceImpl implements DeleteCampusResourcePort {

    private final CampusResourceRepository campusResourceRepository;

    @Override
    public void delete(Long id) {
        campusResourceRepository.delete(id);
    }
}
