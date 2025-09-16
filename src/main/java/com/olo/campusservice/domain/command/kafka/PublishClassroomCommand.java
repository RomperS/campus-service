package com.olo.campusservice.domain.command.kafka;

public record PublishClassroomCommand(
        Long id,
        String identifier,
        Integer capacity
) {
}