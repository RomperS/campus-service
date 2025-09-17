package com.olo.campusservice.infrastructure.dto.request;

public record SearchClassroomRequestDto(
        Long id,
        String identifier,
        Integer capacity,
        Long campusId
) {
}
