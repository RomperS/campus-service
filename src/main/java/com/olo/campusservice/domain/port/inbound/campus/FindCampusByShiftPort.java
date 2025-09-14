package com.olo.campusservice.domain.port.inbound.campus;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;

public interface FindCampusByShiftPort {
    Campus findByShift(Shift shift);
}