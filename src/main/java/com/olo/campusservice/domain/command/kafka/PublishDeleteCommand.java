package com.olo.campusservice.domain.command.kafka;

public record PublishDeleteCommand(
        Long id,
        String entity
) {
}
