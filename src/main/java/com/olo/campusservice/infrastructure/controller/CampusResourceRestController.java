package com.olo.campusservice.infrastructure.controller;

import com.olo.campusservice.application.service.CampusResourceService;
import com.olo.campusservice.domain.command.SearchCampusResourceCommand;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.infrastructure.dto.request.CampusResourceRequestDto;
import com.olo.campusservice.infrastructure.dto.request.ModifyQuantityRequestDto;
import com.olo.campusservice.infrastructure.dto.request.SearchCampusResourceRequestDto;
import com.olo.campusservice.infrastructure.dto.response.CampusResourceResponseDto;
import com.olo.campusservice.infrastructure.mapper.CampusResourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campus-resources")
@RequiredArgsConstructor
public class CampusResourceRestController {

    private final CampusResourceService campusResourceService;

    @GetMapping("/")
    public ResponseEntity<List<CampusResourceResponseDto>> getAll() {
        SearchCampusResourceCommand command = new SearchCampusResourceCommand(
                null,
                null,
                null,
                0,
                null
        );
        List<CampusResource> campusResources = campusResourceService.find(command);
        return ResponseEntity.ok(campusResources.stream().map(CampusResourceMapper::modelToResponseDto).toList());
    }

    @GetMapping("/search")
    public ResponseEntity<List<CampusResourceResponseDto>> search(@ModelAttribute SearchCampusResourceRequestDto requestDto) {
        SearchCampusResourceCommand command = CampusResourceMapper.searchRequestDtoToCommand(requestDto);
        List<CampusResource> campusResources = campusResourceService.find(command);
        return ResponseEntity.ok(campusResources.stream().map(CampusResourceMapper::modelToResponseDto).toList());
    }

    @PostMapping("/")
    public ResponseEntity<CampusResourceResponseDto> create(@Validated @RequestBody CampusResourceRequestDto requestDto) {
        CampusResource campusResource = campusResourceService.create(CampusResourceMapper.requestDtoToCommand(requestDto));
        return ResponseEntity.ok(CampusResourceMapper.modelToResponseDto(campusResource));
    }

    @PatchMapping("/")
    public ResponseEntity<CampusResourceResponseDto> modifyQuantity(@Validated @RequestBody ModifyQuantityRequestDto requestDto) {
        CampusResource campusResource = campusResourceService.modifyQuantity(CampusResourceMapper.modifyRequestDtoToCommand(requestDto));
        return ResponseEntity.ok(CampusResourceMapper.modelToResponseDto(campusResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        campusResourceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
