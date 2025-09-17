package com.olo.campusservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResourceRequestDto(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        String supplier,
        @NotNull
        @NotBlank
        String description
) {
}
