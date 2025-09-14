package com.olo.campusservice.domain.port.inbound.classroom;

import com.olo.campusservice.domain.command.SearchClassroomCommand;
import com.olo.campusservice.domain.model.Classroom;

public interface FindClassroomPort {
    Classroom find(SearchClassroomCommand command);
}