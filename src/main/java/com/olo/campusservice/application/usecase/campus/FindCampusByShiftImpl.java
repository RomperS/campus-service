package com.olo.campusservice.application.usecase.campus;

import com.olo.campusservice.domain.exception.exists.CampusNotFoundException;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;
import com.olo.campusservice.domain.port.inbound.campus.FindCampusByShiftPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindCampusByShiftImpl implements FindCampusByShiftPort {

    private final CampusRepository campusRepository;

    @Override
    public Campus findByShift(Shift shift) {
        return campusRepository.findByShift(shift).orElseThrow(() -> new CampusNotFoundException("Campus not found"));
    }
}
