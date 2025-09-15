package com.olo.campusservice.infrastructure.mapper;

import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.infrastructure.entity.ResourceEntity;

public class ResourceMapper {

    public static Resource entityToModel(ResourceEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Resource(
                entity.getId(),
                entity.getName(),
                entity.getSupplier(),
                entity.getDescription()
        );
    }

    public static ResourceEntity modelToEntity(Resource model) {
        if (model == null) {
            return null;
        }

        return new ResourceEntity(
                model.id(),
                model.name(),
                model.supplierName(),
                model.description()
        );
    }
}
