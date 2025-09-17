package com.olo.campusservice.application.usecase.classroom;

import com.olo.campusservice.domain.command.UpdatedClassroomCommand;
import com.olo.campusservice.domain.command.kafka.PublishClassroomCommand;
import com.olo.campusservice.domain.exception.exists.ClassroomIdentifierTakenException;
import com.olo.campusservice.domain.exception.exists.ClassroomNotFoundException;
import com.olo.campusservice.domain.exception.value.InvalidIdentifierValueException;
import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.domain.port.inbound.classroom.UpdateClassroomPort;
import com.olo.campusservice.domain.port.outbound.ClassroomRepository;
import com.olo.campusservice.domain.port.outbound.KafkaServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateClassroomImpl implements UpdateClassroomPort {

    private final ClassroomRepository classroomRepository;
    private final KafkaServicePort kafkaServicePort;

    @Override
    public Classroom updateClassroom(UpdatedClassroomCommand command) {
        Classroom targetClassroom = classroomRepository.findById(command.id()).orElseThrow(() -> new ClassroomNotFoundException("Classroom not found"));

        String identifier = targetClassroom.identifier();
        if (command.identifier() != null && !command.identifier().equals(identifier)) {
            if (command.identifier().isBlank()){
                throw new InvalidIdentifierValueException("identifier is empty");
            }
            if (classroomRepository.existsByIdentifierInCampus(command.identifier(), targetClassroom.campus())){
                throw new ClassroomIdentifierTakenException("Identifier is already taken");
            }
            identifier = command.identifier();
        }

        Integer capacity = targetClassroom.capacity();
        if (command.capacity() > 0){
            capacity = command.capacity();
        }

        Classroom updatedClassroom = new Classroom(
                targetClassroom.id(),
                identifier,
                capacity,
                targetClassroom.campus()
        );

        Classroom savedClassroom = classroomRepository.save(updatedClassroom);

        sendModify(savedClassroom.id(), savedClassroom.identifier(), savedClassroom.capacity());

        return savedClassroom;
    }

    private void sendModify(Long id, String identifier, Integer capacity){
        PublishClassroomCommand command = new PublishClassroomCommand(
                id,
                identifier,
                capacity
        );

        kafkaServicePort.publishUpdateClassroom(command);
    }
}
