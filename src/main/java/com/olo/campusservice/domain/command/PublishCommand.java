package com.olo.campusservice.domain.command;

public record PublishCommand(
        Long id,
        String object
) {
}
