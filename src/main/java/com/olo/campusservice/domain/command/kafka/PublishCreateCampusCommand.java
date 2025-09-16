package com.olo.campusservice.domain.command.kafka;

public record PublishCreateCampusCommand(
        Long id,
        String name
) {
}
