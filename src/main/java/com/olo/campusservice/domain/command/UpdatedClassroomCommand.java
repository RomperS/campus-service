package com.olo.campusservice.domain.command;

public record UpdatedClassroomCommand(
        Long id,
        String identifier,
        Integer capacity
) {
}