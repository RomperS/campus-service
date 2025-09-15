package com.olo.campusservice.infrastructure.mapper;

import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.infrastructure.entity.ClassroomEntity;

public class ClassroomMapper {

    public static ClassroomEntity modelToEntity(Classroom model) {
        if (model == null) {
            return null;
        }

        return new ClassroomEntity(
                model.id(),
                model.identifier(),
                model.capacity(),
                CampusMapper.modelToEntity(model.campus())
        );
    }

    public static Classroom entityToModel(ClassroomEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Classroom(
                entity.getId(),
                entity.getIdentifier(),
                entity.getCapacity(),
                CampusMapper.entityToModel(entity.getCampus())
        );
    }
}
