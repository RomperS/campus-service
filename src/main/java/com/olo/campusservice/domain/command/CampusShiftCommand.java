package com.olo.campusservice.domain.command;

import com.olo.campusservice.domain.model.enums.Shift;

public record CampusShiftCommand(
        Long id,
        Shift shift,
        boolean addShift
) {
}
