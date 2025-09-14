package com.olo.campusservice.domain.port.inbound.campus;

import com.olo.campusservice.domain.model.Campus;

public interface CreateCampusPort {
    Campus create(Campus campus);
}