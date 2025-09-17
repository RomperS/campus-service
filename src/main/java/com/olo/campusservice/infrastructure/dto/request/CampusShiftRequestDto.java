package com.olo.campusservice.infrastructure.dto.request;

import com.olo.campusservice.domain.model.enums.Shift;
import jakarta.validation.constraints.NotNull;

public record CampusShiftRequestDto(
        @NotNull
        Long id,
        @NotNull
        Shift shift,
        @NotNull
        boolean addShift
) {
}
