package com.olo.campusservice.application.usecase.campus;

import com.olo.campusservice.domain.exception.exists.CampusNameTakenException;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.port.inbound.campus.CreateCampusPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCampusImpl implements CreateCampusPort {

    private final CampusRepository campusRepository;

    @Override
    public Campus create(Campus campus) {
        if (campusRepository.existsByName(campus.name())){
            throw new CampusNameTakenException("Campus name is taken");
        }

        Campus newCampus = new Campus(
                null,
                campus.name(),
                campus.address(),
                campus.shifts()
        );

        return campusRepository.save(newCampus);
    }
}
