package com.olo.campusservice.infrastructure.controller;

import com.olo.campusservice.application.service.CampusService;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;
import com.olo.campusservice.infrastructure.dto.request.CampusRequestDto;
import com.olo.campusservice.infrastructure.dto.request.CampusShiftRequestDto;
import com.olo.campusservice.infrastructure.dto.response.CampusResponseDto;
import com.olo.campusservice.infrastructure.mapper.CampusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campuses")
@RequiredArgsConstructor
public class CampusRestController {

    private final CampusService campusService;

    @GetMapping("/")
    public ResponseEntity<List<Campus>> getAllCampuses() {
        List<Campus> campuses = campusService.FindAllCampus();
        return ResponseEntity.ok().body(campuses);
    }

    @GetMapping("/{shift}")
    public ResponseEntity<List<CampusResponseDto>> findCampusById(@PathVariable Shift shift) {
        List<Campus> campusList = campusService.findByShift(shift);
        return ResponseEntity.ok().body(campusList.stream().map(CampusMapper::modelToDto).toList());
    }

    @PostMapping("/")
    public ResponseEntity<CampusResponseDto> createCampus(@Validated @RequestBody CampusRequestDto requestDto) {
        Campus createCampus = campusService.create(CampusMapper.dtoToModel(requestDto));
        return ResponseEntity.ok(CampusMapper.modelToDto(createCampus));
    }

    @PatchMapping("/")
    public ResponseEntity<CampusResponseDto> modifyShift(@Validated @RequestBody CampusShiftRequestDto requestDto) {
        Campus campus = campusService.modifyCampusShift(CampusMapper.dtoToCommand(requestDto));
        return ResponseEntity.ok(CampusMapper.modelToDto(campus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCampus(@PathVariable Long id) {
        campusService.delete(id);
        return ResponseEntity.ok().build();
    }
}