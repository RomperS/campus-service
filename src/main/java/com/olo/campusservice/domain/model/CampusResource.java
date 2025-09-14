package com.olo.campusservice.domain.model;

import com.olo.campusservice.domain.model.enums.State;

public record CampusResource(
        Long id,
        Campus campus,
        Resource resource,
        int quantity,
        State state
) {
}