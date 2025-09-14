package com.olo.campusservice.domain.port.outbound;

import com.olo.campusservice.domain.command.PublishCommand;

public interface KafkaServicePort {
    void publishCreate(PublishCommand command);
    void publishUpdateClassroom(PublishCommand command);
    void publishDelete(PublishCommand command);
}
