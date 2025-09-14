package com.olo.campusservice.domain.model;

public record Classroom(
        Long id,
        String identifier,
        Integer capacity,
        Campus campus
) {
}