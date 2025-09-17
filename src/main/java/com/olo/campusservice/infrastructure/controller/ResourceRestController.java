package com.olo.campusservice.infrastructure.controller;

import com.olo.campusservice.application.service.ResourceService;
import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.infrastructure.dto.request.ResourceRequestDto;
import com.olo.campusservice.infrastructure.dto.request.UpdateResourceRequestDto;
import com.olo.campusservice.infrastructure.dto.response.ResourceResponseDto;
import com.olo.campusservice.infrastructure.mapper.ResourceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
@RequiredArgsConstructor
public class ResourceRestController {

    private final ResourceService resourceService;

    @GetMapping("/")
    public ResponseEntity<List<ResourceResponseDto>> findAll() {
        List<Resource> resources = resourceService.findAll();
        return ResponseEntity.ok(resources.stream().map(ResourceMapper::modelToResponseDto).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponseDto> findById(@PathVariable Long id) {
        Resource resource = resourceService.findById(id);
        return ResponseEntity.ok(ResourceMapper.modelToResponseDto(resource));
    }

    @GetMapping("/name")
    public ResponseEntity<List<ResourceResponseDto>> findByName(@RequestParam String name) {
        List<Resource> resources = resourceService.findByName(name);
        return ResponseEntity.ok(resources.stream().map(ResourceMapper::modelToResponseDto).toList());
    }

    @GetMapping("/supplier")
    public ResponseEntity<List<ResourceResponseDto>> findBySupplier(@RequestParam String supplier) {
        List<Resource> resources = resourceService.findBySupplier(supplier);
        return ResponseEntity.ok(resources.stream().map(ResourceMapper::modelToResponseDto).toList());
    }

    @PostMapping("/")
    public ResponseEntity<ResourceResponseDto> create(@Validated @RequestBody ResourceRequestDto dto) {
        Resource resource = resourceService.create(ResourceMapper.requestDtoToModel(dto));
        return ResponseEntity.ok(ResourceMapper.modelToResponseDto(resource));
    }

    @PatchMapping("/")
    public ResponseEntity<ResourceResponseDto> update(@Validated @RequestBody UpdateResourceRequestDto dto) {
        Resource resource = resourceService.update(ResourceMapper.updateDtoToModel(dto));
        return ResponseEntity.ok(ResourceMapper.modelToResponseDto(resource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        resourceService.delete(id);
        return ResponseEntity.ok().build();
    }
}
