package com.olo.campusservice.domain.port.outbound;

import com.olo.campusservice.domain.command.kafka.PublishClassroomCommand;
import com.olo.campusservice.domain.command.kafka.PublishCreateCampusCommand;
import com.olo.campusservice.domain.command.kafka.PublishDeleteCommand;
import com.olo.campusservice.domain.command.kafka.PublishShiftCommand;

public interface KafkaServicePort {
    void publishCreateClassroom(PublishClassroomCommand command);
    void publishCreateCampus(PublishCreateCampusCommand command);
    void publishUpdateClassroom(PublishClassroomCommand command);
    void publishRemoveShift(PublishShiftCommand command);
    void publishDelete(PublishDeleteCommand command);
}
