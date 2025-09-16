package com.olo.campusservice.application.usecase.classroom;

import com.olo.campusservice.domain.command.kafka.PublishDeleteCommand;
import com.olo.campusservice.domain.port.inbound.classroom.DeleteClassroomPort;
import com.olo.campusservice.domain.port.outbound.ClassroomRepository;
import com.olo.campusservice.domain.port.outbound.KafkaServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteClassroomImpl implements DeleteClassroomPort {

    private final ClassroomRepository classroomRepository;
    private final KafkaServicePort kafkaServicePort;

    @Override
    public void delete(Long id) {
        classroomRepository.delete(id);
        sendModify(id);
    }

    private void sendModify(Long id){
        PublishDeleteCommand command = new PublishDeleteCommand(
                id,
                "Classroom"
        );

        kafkaServicePort.publishDelete(command);
    }
}
