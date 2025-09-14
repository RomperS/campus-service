package com.olo.campusservice.domain.command;

public record SearchClassroomCommand(
        Long id,
        String identifier,
        Integer capacity,
        Long campusId
) {
}
