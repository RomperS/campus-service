package com.olo.campusservice.infrastructure.dto.request;

import com.olo.campusservice.domain.model.enums.State;
import jakarta.validation.constraints.NotNull;

public record SearchCampusResourceRequestDto(
        Long id,
        Long campusId,
        Long resourceId,
        @NotNull
        int quantity,
        State state
) {
}
