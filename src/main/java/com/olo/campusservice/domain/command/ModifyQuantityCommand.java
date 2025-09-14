package com.olo.campusservice.domain.command;

public record ModifyQuantityCommand(
        Long id,
        int quantity
) {
}
