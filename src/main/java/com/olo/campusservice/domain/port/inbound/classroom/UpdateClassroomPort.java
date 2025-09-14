package com.olo.campusservice.domain.port.inbound.classroom;

import com.olo.campusservice.domain.command.UpdatedClassroomCommand;
import com.olo.campusservice.domain.model.Classroom;

public interface UpdateClassroomPort {
    Classroom updateClassroom(UpdatedClassroomCommand classroom);
}