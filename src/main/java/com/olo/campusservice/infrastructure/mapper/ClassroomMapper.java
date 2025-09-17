package com.olo.campusservice.infrastructure.mapper;

import com.olo.campusservice.domain.command.SearchClassroomCommand;
import com.olo.campusservice.domain.command.UpdatedClassroomCommand;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.infrastructure.dto.request.ClassroomRequestDto;
import com.olo.campusservice.infrastructure.dto.request.SearchClassroomRequestDto;
import com.olo.campusservice.infrastructure.dto.request.UpdateClassroomRequestDto;
import com.olo.campusservice.infrastructure.dto.response.ClassroomResponseDto;
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

    public static SearchClassroomCommand searchDtoToCommand(SearchClassroomRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new SearchClassroomCommand(
                dto.id(),
                dto.identifier(),
                dto.capacity(),
                dto.campusId()
        );
    }

    public static UpdatedClassroomCommand updateDtoToCommand(UpdateClassroomRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new UpdatedClassroomCommand(
                dto.id(),
                dto.identifier(),
                dto.capacity()
        );
    }

    public static ClassroomResponseDto modelToResponseDto(Classroom model) {
        if (model == null) {
            return null;
        }

        return new ClassroomResponseDto(
                model.id(),
                model.identifier(),
                model.capacity(),
                model.campus().id()
        );
    }

    public static Classroom requestDtoToEntity(ClassroomRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Campus campus = new Campus(
                dto.campusId(),
                null,
                null,
                null
        );

        return new  Classroom(
                null,
                dto.identifier(),
                dto.capacity(),
                campus
        );
    }
}
