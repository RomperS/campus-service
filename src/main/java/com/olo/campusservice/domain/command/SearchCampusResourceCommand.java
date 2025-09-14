package com.olo.campusservice.domain.command;

import com.olo.campusservice.domain.model.enums.State;

import java.util.Optional;

public record SearchCampusResourceCommand(
        Long id,
        Long campusId,
        Long resourceId,
        int quantity,
        Optional<State> state
) {
}
