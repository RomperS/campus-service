package com.olo.campusservice.infrastructure.dto.request;

import jakarta.validation.constraints.NotNull;

public record ModifyQuantityRequestDto(
        @NotNull
        Long id,
        @NotNull
        int quantity
) {
}
