package com.olo.campusservice.application.usecase.campus;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.port.inbound.campus.FindAllCampusPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllCampusImpl implements FindAllCampusPort {

    private final CampusRepository campusRepository;

    @Override
    public List<Campus> FindAllCampus() {
        return campusRepository.findAll();
    }
}
