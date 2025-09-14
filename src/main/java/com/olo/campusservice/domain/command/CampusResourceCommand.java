package com.olo.campusservice.domain.command;

import com.olo.campusservice.domain.model.enums.State;

public record CampusResourceCommand(
        Long campusId,
        Long resourceId,
        int quantity,
        State state
) {
}