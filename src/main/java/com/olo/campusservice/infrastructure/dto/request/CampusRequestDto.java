package com.olo.campusservice.infrastructure.dto.request;

import com.olo.campusservice.domain.model.enums.Shift;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record CampusRequestDto(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        String address,
        @NotNull
        Set<Shift> shifts
) {
}