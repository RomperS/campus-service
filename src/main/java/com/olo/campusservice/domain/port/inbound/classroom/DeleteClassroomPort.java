package com.olo.campusservice.domain.port.inbound.classroom;

import com.olo.campusservice.domain.model.Classroom;

public interface DeleteClassroomPort {
    void delete(Long id);
}
