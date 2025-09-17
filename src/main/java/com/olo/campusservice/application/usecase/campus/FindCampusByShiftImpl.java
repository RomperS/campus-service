package com.olo.campusservice.application.usecase.campus;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;
import com.olo.campusservice.domain.port.inbound.campus.FindCampusByShiftPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindCampusByShiftImpl implements FindCampusByShiftPort {

    private final CampusRepository campusRepository;

    @Override
    public List<Campus> findByShift(Shift shift) {
        return campusRepository.findByShift(shift);
    }
}
