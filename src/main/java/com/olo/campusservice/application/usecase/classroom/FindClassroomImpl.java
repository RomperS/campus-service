package com.olo.campusservice.application.usecase.classroom;

import com.olo.campusservice.domain.command.SearchClassroomCommand;
import com.olo.campusservice.domain.exception.exists.CampusNotFoundException;
import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.domain.port.inbound.classroom.FindClassroomPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import com.olo.campusservice.domain.port.outbound.ClassroomRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindClassroomImpl implements FindClassroomPort {

    private final ClassroomRepository classroomRepository;
    private final CampusRepository campusRepository;

    @Override
    public List<Classroom> find(SearchClassroomCommand command) {
        if (!campusRepository.existsById(command.campusId())){
            throw new CampusNotFoundException("Campus not found");
        }

        List<Classroom> classrooms = classroomRepository.findAll();

        return classrooms.stream()
                .filter(c -> byId(command.id(), c))
                .filter(c -> byIdentifier(command.identifier(), c))
                .filter(c -> byCampusId(command.campusId(), c))
                .filter(c -> byCapacity(command.capacity(), c))
                .toList();
    }

    private boolean byId(Long id, Classroom classroom) {
        if (id == null) return true;
        return id.equals(classroom.id());
    }

    private boolean byIdentifier(String identifier, Classroom classroom) {
        if (identifier == null || identifier.isEmpty()) return true;
        return identifier.equals(classroom.identifier());
    }

    private boolean byCampusId(Long campusId, Classroom classroom) {
        if (campusId == null) return true;
        return campusId.equals(classroom.campus().id());
    }

    private boolean byCapacity(Integer capacity, Classroom classroom) {
        if (capacity <= 0) return true;
        return capacity <= classroom.capacity();
    }
}
