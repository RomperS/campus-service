package com.olo.campusservice.application.service;

import com.olo.campusservice.application.usecase.classroom.CreateClassroomImpl;
import com.olo.campusservice.application.usecase.classroom.DeleteClassroomImpl;
import com.olo.campusservice.application.usecase.classroom.FindClassroomImpl;
import com.olo.campusservice.application.usecase.classroom.UpdateClassroomImpl;
import com.olo.campusservice.domain.command.SearchClassroomCommand;
import com.olo.campusservice.domain.command.UpdatedClassroomCommand;
import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.domain.port.inbound.classroom.CreateClassroomPort;
import com.olo.campusservice.domain.port.inbound.classroom.DeleteClassroomPort;
import com.olo.campusservice.domain.port.inbound.classroom.FindClassroomPort;
import com.olo.campusservice.domain.port.inbound.classroom.UpdateClassroomPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClassroomService implements CreateClassroomPort, DeleteClassroomPort, FindClassroomPort, UpdateClassroomPort {

    private final CreateClassroomImpl  createClassroomImpl;
    private final DeleteClassroomImpl deleteClassroomImpl;
    private final FindClassroomImpl findClassroomImpl;
    private final UpdateClassroomImpl updateClassroomImpl;


    @Override
    public Classroom create(Classroom classroom) {
        return createClassroomImpl.create(classroom);
    }

    @Override
    public void delete(Long id) {
        deleteClassroomImpl.delete(id);
    }

    @Override
    public List<Classroom> find(SearchClassroomCommand command) {
        return findClassroomImpl.find(command);
    }

    @Override
    public Classroom updateClassroom(UpdatedClassroomCommand classroom) {
        return updateClassroomImpl.updateClassroom(classroom);
    }
}
