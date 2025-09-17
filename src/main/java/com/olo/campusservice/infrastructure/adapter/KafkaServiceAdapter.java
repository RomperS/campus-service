package com.olo.campusservice.infrastructure.adapter;

import com.olo.campusservice.domain.command.kafka.PublishClassroomCommand;
import com.olo.campusservice.domain.command.kafka.PublishCreateCampusCommand;
import com.olo.campusservice.domain.command.kafka.PublishDeleteCommand;
import com.olo.campusservice.domain.command.kafka.PublishShiftCommand;
import com.olo.campusservice.domain.port.outbound.KafkaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaServiceAdapter implements KafkaServicePort {

    private final KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void publishCreateClassroom(PublishClassroomCommand command) {
        String topic = formatTopic("Classroom", "Created");
        String msg = String.format("Classroom created. id: %d, identifier: %s, capacity: %s", command.id(), command.identifier(), command.capacity());

        kafkaTemplate.send(topic, msg);
    }

    @Override
    public void publishCreateCampus(PublishCreateCampusCommand command) {
        String topic = formatTopic("Campus", "Created");
        String msg = String.format("Campus created. id: %d, name: %s", command.id(), command.name());

        kafkaTemplate.send(topic, msg);
    }

    @Override
    public void publishUpdateClassroom(PublishClassroomCommand command) {
        String topic = formatTopic("Classroom", "Updated");
        String msg = String.format("Classroom updated. id: %d, identifier: %s, capacity: %s", command.id(), command.identifier(), command.capacity());

        kafkaTemplate.send(topic, msg);
    }

    @Override
    public void publishRemoveShift(PublishShiftCommand command) {
        String topic = formatTopic("Campus", "Remove-Shift");
        String msg = String.format("Campus created. id: %d, name: %s", command.id(), command.shift());

        kafkaTemplate.send(topic, msg);
    }

    @Override
    public void publishDelete(PublishDeleteCommand command) {
        String topic = formatTopic(command.entity(), "Deleted");
        String msg = String.format("%s created. id: %d", command.entity(), command.id());

        kafkaTemplate.send(topic, msg);
    }

    private String formatTopic(String entity, String action){
        return String.format("%s-%s", entity, action).toLowerCase();
    }
}