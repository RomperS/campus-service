package com.olo.campusservice.domain.model;

import java.util.List;

public record Campus(
        Long id,
        String name,
        String address,
        List<String> classroomsIdentifiers
) {
}