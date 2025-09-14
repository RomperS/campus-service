package com.olo.campusservice.application.usecase.classroom;

import com.olo.campusservice.domain.exception.exists.CampusNotFoundException;
import com.olo.campusservice.domain.exception.exists.ClassroomIdentifierTakenException;
import com.olo.campusservice.domain.exception.value.InvalidCapacityValueException;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.domain.port.inbound.classroom.CreateClassroomPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import com.olo.campusservice.domain.port.outbound.ClassroomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateClassroomImpl implements CreateClassroomPort {

    private final ClassroomRepository classroomRepository;
    private final CampusRepository campusRepository;

    @Override
    public Classroom create(Classroom classroom) {
        Campus campus = campusRepository.findById(classroom.campus().id()).orElseThrow(() -> new CampusNotFoundException("Campus not found"));

        if (classroomRepository.existsByIdentifierInCampus(classroom.identifier(), classroom.campus())) {
            throw new ClassroomIdentifierTakenException("Identifier is already taken in this campus");
        }

        if (classroom.capacity() <= 0){
            throw new InvalidCapacityValueException("Capacity must be greater than 0");
        }

        Classroom newClassroom = new Classroom(
                null,
                classroom.identifier(),
                classroom.capacity(),
                campus
        );

        return classroomRepository.save(newClassroom);
    }
}
