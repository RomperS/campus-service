package com.olo.campusservice.domain.model;

public record Resource(
        Long id,
        String name,
        String supplierName,
        String description
) {
}