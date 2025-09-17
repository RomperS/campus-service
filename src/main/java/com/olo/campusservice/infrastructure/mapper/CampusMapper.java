package com.olo.campusservice.infrastructure.mapper;

import com.olo.campusservice.domain.command.CampusShiftCommand;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.infrastructure.dto.request.CampusRequestDto;
import com.olo.campusservice.infrastructure.dto.request.CampusShiftRequestDto;
import com.olo.campusservice.infrastructure.dto.response.CampusResponseDto;
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

    public static Campus dtoToModel(CampusRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return new Campus(
                null,
                dto.name(),
                dto.address(),
                dto.shifts()
        );
    }

    public static CampusResponseDto modelToDto(Campus model) {
        if (model == null) {
            return null;
        }

        return new CampusResponseDto(
                model.id(),
                model.name(),
                model.address(),
                model.shifts()
        );
    }

    public static CampusShiftCommand dtoToCommand(CampusShiftRequestDto dto){
        if (dto == null) {
            return null;
        }

        return new CampusShiftCommand(
                dto.id(),
                dto.shift(),
                dto.addShift()
        );
    }
}
