package com.olo.campusservice.domain.model;

import com.olo.campusservice.domain.model.enums.Shift;

import java.util.Set;

public record Campus(
        Long id,
        String name,
        String address,
        Set<Shift> shifts
) {
}