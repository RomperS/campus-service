package com.olo.campusservice.infrastructure.dto.response;

import com.olo.campusservice.domain.model.enums.State;

public record CampusResourceResponseDto(
        Long id,
        Long campusId,
        Long resourceId,
        int quantity,
        State state
) {
}