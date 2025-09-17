package com.olo.campusservice.infrastructure.dto.response;

public record ClassroomResponseDto (
        Long id,
        String identifier,
        Integer capacity,
        Long campusId
) {
}