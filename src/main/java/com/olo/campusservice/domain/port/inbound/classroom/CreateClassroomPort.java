package com.olo.campusservice.domain.port.inbound.classroom;

import com.olo.campusservice.domain.model.Classroom;

public interface CreateClassroomPort {
    Classroom create(Classroom classroom);
}