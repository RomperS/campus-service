package com.olo.campusservice.domain.port.inbound.campus;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;

import java.util.List;

public interface FindCampusByShiftPort {
    List<Campus> findByShift(Shift shift);
}