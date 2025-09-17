package com.olo.campusservice.infrastructure.dto.request;

import com.olo.campusservice.domain.model.enums.State;
import jakarta.validation.constraints.NotNull;

public record CampusResourceRequestDto(
        @NotNull
        Long campusId,
        @NotNull
        Long resourceId,
        @NotNull
        int quantity,
        @NotNull
        State state
) {
}
