package com.olo.campusservice.domain.port.inbound.classroom;

import com.olo.campusservice.domain.command.SearchClassroomCommand;
import com.olo.campusservice.domain.model.Classroom;

import java.util.List;

public interface FindClassroomPort {
    List<Classroom> find(SearchClassroomCommand command);
}