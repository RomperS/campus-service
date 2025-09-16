package com.olo.campusservice.domain.command.kafka;

import com.olo.campusservice.domain.model.enums.Shift;

public record PublishShiftCommand(
        Long id,
        Shift shift
) {
}
