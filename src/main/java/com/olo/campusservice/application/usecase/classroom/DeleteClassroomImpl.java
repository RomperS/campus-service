package com.olo.campusservice.application.usecase.classroom;

import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.domain.port.inbound.classroom.DeleteClassroomPort;
import com.olo.campusservice.domain.port.outbound.ClassroomRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteClassroomImpl implements DeleteClassroomPort {

    private final ClassroomRepository classroomRepository;

    @Override
    public void delete(Long id) {
        classroomRepository.delete(id);
    }
}
