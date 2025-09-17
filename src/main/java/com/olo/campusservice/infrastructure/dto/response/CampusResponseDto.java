package com.olo.campusservice.infrastructure.dto.response;

import com.olo.campusservice.domain.model.enums.Shift;

import java.util.Set;

public record CampusResponseDto(
        Long id,
        String name,
        String address,
        Set<Shift> shifts
) {
}
