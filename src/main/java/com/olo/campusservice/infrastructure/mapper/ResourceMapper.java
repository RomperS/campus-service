package com.olo.campusservice.infrastructure.mapper;

import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.infrastructure.dto.request.ResourceRequestDto;
import com.olo.campusservice.infrastructure.dto.request.UpdateResourceRequestDto;
import com.olo.campusservice.infrastructure.dto.response.ResourceResponseDto;
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

    public static ResourceResponseDto modelToResponseDto(Resource model) {
        if (model == null) {
            return null;
        }

        return new ResourceResponseDto(
                model.id(),
                model.name(),
                model.supplierName(),
                model.description()
        );
    }

    public static Resource requestDtoToModel(ResourceRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new Resource(
                null,
                dto.name(),
                dto.supplier(),
                dto.description()
        );
    }

    public static Resource updateDtoToModel(UpdateResourceRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new Resource(
                dto.id(),
                dto.name(),
                null,
                dto.description()
        );
    }
}
