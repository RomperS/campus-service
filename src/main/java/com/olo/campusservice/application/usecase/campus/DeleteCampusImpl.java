package com.olo.campusservice.application.usecase.campus;

import com.olo.campusservice.domain.port.inbound.campus.DeleteCampusPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCampusImpl implements DeleteCampusPort {

    private final CampusRepository campusRepository;

    @Override
    public void delete(Long id) {
        campusRepository.delete(id);
    }
}
