package com.olo.campusservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateResourceRequestDto(
        @NotNull
        Long id,
        String name,
        String description
) {
}
