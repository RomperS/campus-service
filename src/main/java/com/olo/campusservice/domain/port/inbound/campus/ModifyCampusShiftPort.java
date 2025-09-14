package com.olo.campusservice.domain.port.inbound.campus;

import com.olo.campusservice.domain.command.CampusShiftCommand;
import com.olo.campusservice.domain.model.Campus;

public interface ModifyCampusShiftPort {
    Campus modifyCampusShift(CampusShiftCommand campus);
}