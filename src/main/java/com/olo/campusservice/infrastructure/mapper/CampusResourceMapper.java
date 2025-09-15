package com.olo.campusservice.infrastructure.mapper;

import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.infrastructure.entity.CampusResourceEntity;

public class CampusResourceMapper {

    public static CampusResource entityToModel(CampusResourceEntity entity) {
        if (entity == null) {
            return null;
        }

        return new CampusResource(
                entity.getId(),
                CampusMapper.entityToModel(entity.getCampus()),
                ResourceMapper.entityToModel(entity.getResource()),
                entity.getQuantity(),
                entity.getState()
        );
    }

    public static CampusResourceEntity modelToEntity(CampusResource model) {
        if (model == null) {
            return null;
        }

        return new CampusResourceEntity(
                model.id(),
                CampusMapper.modelToEntity(model.campus()),
                ResourceMapper.modelToEntity(model.resource()),
                model.quantity(),
                model.state()
        );
    }
}
