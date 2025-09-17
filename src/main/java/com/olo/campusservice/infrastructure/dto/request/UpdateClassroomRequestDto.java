package com.olo.campusservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateClassroomRequestDto(
        @NotNull
        Long id,
        String identifier,
        Integer capacity
) {
}