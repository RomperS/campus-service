package com.olo.campusservice.infrastructure.mapper;

import com.olo.campusservice.domain.command.CampusResourceCommand;
import com.olo.campusservice.domain.command.ModifyQuantityCommand;
import com.olo.campusservice.domain.command.SearchCampusResourceCommand;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.infrastructure.dto.request.CampusResourceRequestDto;
import com.olo.campusservice.infrastructure.dto.request.ModifyQuantityRequestDto;
import com.olo.campusservice.infrastructure.dto.request.SearchCampusResourceRequestDto;
import com.olo.campusservice.infrastructure.dto.response.CampusResourceResponseDto;
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

    public static CampusResourceResponseDto modelToResponseDto(CampusResource model) {
        if (model == null) {
            return null;
        }

        return new CampusResourceResponseDto(
                model.id(),
                model.campus().id(),
                model.resource().id(),
                model.quantity(),
                model.state()
        );
    }

    public static SearchCampusResourceCommand searchRequestDtoToCommand(SearchCampusResourceRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new SearchCampusResourceCommand(
                dto.id(),
                dto.campusId(),
                dto.resourceId(),
                dto.quantity(),
                dto.state()
        );
    }

    public static CampusResourceCommand requestDtoToCommand(CampusResourceRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new CampusResourceCommand(
                dto.campusId(),
                dto.resourceId(),
                dto.quantity(),
                dto.state()
        );
    }

    public static ModifyQuantityCommand modifyRequestDtoToCommand(ModifyQuantityRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new ModifyQuantityCommand(
                dto.id(),
                dto.quantity()
        );
    }
}
