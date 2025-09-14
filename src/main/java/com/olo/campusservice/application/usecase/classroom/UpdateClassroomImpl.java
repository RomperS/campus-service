package com.olo.campusservice.application.usecase.classroom;

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
    public Classroom updateClassroom(Classroom classroom) {
        Classroom targetClassroom = classroomRepository.findById(classroom.id()).orElseThrow(() -> new ClassroomNotFoundException("Classroom not found"));

        String identifier = targetClassroom.identifier();
        if (classroom.identifier() != null && !classroom.identifier().equals(identifier)) {
            if (classroomRepository.existsByIdentifierInCampus(classroom.identifier(), targetClassroom.campus())){
                throw new ClassroomIdentifierTakenException("Identifier is already taken");
            }
            identifier = classroom.identifier();
        }

        Integer capacity = targetClassroom.capacity();
        if (classroom.capacity() > 0){
            capacity = classroom.capacity();
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
