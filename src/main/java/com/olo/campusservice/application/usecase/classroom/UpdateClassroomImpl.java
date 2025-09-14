package com.olo.campusservice.application.usecase.classroom;

import com.olo.campusservice.domain.command.UpdatedClassroomCommand;
import com.olo.campusservice.domain.exception.exists.ClassroomIdentifierTakenException;
import com.olo.campusservice.domain.exception.exists.ClassroomNotFoundException;
import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.domain.port.inbound.classroom.UpdateClassroomPort;
import com.olo.campusservice.domain.port.outbound.ClassroomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateClassroomImpl implements UpdateClassroomPort {

    private final ClassroomRepository classroomRepository;

    @Override
    public Classroom updateClassroom(UpdatedClassroomCommand command) {
        Classroom targetClassroom = classroomRepository.findById(command.id()).orElseThrow(() -> new ClassroomNotFoundException("Classroom not found"));

        String identifier = targetClassroom.identifier();
        if (command.identifier() != null && !command.identifier().equals(identifier)) {
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

        return classroomRepository.save(updatedClassroom);
    }
}
