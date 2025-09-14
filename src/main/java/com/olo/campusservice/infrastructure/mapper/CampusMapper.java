package com.olo.campusservice.infrastructure.mapper;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.infrastructure.entity.CampusEntity;

public class CampusMapper {

    public static CampusEntity modelToEntity(Campus model) {
        if (model == null) {
            return null;
        }

        return new CampusEntity(
                model.id(),
                model.name(),
                model.address(),
                model.shifts()
        );
    }

    public static Campus entityToModel(CampusEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Campus(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getShifts()
        );
    }
}
