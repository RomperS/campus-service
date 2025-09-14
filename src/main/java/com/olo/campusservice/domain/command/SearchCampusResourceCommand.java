package com.olo.campusservice.domain.command;

import com.olo.campusservice.domain.model.enums.State;

public record SearchCampusResourceCommand(
        Long id,
        Long campusId,
        Long resourceId,
        int quantity,
        State state
) {
}
