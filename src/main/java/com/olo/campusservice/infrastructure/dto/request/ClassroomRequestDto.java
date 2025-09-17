package com.olo.campusservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClassroomRequestDto(
        @NotNull
        @NotBlank
        String identifier,
        @NotNull
        Integer capacity,
        @NotNull
        Long campusId
) {
}