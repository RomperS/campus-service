package com.olo.campusservice.infrastructure.dto.response;

public record ResourceResponseDto(
        Long id,
        String name,
        String supplierName,
        String description
) {
}