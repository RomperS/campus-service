package com.olo.campusservice.infrastructure.controller;

import com.olo.campusservice.application.service.ClassroomService;
import com.olo.campusservice.domain.command.SearchClassroomCommand;
import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.infrastructure.dto.request.ClassroomRequestDto;
import com.olo.campusservice.infrastructure.dto.request.SearchClassroomRequestDto;
import com.olo.campusservice.infrastructure.dto.request.UpdateClassroomRequestDto;
import com.olo.campusservice.infrastructure.dto.response.ClassroomResponseDto;
import com.olo.campusservice.infrastructure.mapper.ClassroomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
@RequiredArgsConstructor
public class ClassroomRestController {

    private final ClassroomService classroomService;

    @GetMapping("/search")
    public ResponseEntity<List<ClassroomResponseDto>> searchClassrooms(@ModelAttribute SearchClassroomRequestDto command) {
        List<Classroom> classrooms = classroomService.find(ClassroomMapper.searchDtoToCommand(command));
        return ResponseEntity.ok().body(classrooms.stream().map(ClassroomMapper::modelToResponseDto).toList());
    }

    @GetMapping("/")
    public ResponseEntity<List<ClassroomResponseDto>> getAllClassrooms() {
        SearchClassroomCommand command = new SearchClassroomCommand(null, null, 0, null);
        List<Classroom> classrooms = classroomService.find(command);
        return ResponseEntity.ok().body(classrooms.stream().map(ClassroomMapper::modelToResponseDto).toList());
    }

    @PostMapping("/")
    public ResponseEntity<ClassroomResponseDto> create(@Validated @RequestBody ClassroomRequestDto command) {
        Classroom classroom = classroomService.create(ClassroomMapper.requestDtoToEntity(command));
        return ResponseEntity.ok().body(ClassroomMapper.modelToResponseDto(classroom));
    }

    @PatchMapping("/")
    public ResponseEntity<ClassroomResponseDto> update(@Validated @RequestBody UpdateClassroomRequestDto command) {
        Classroom classroom = classroomService.updateClassroom(ClassroomMapper.updateDtoToCommand(command));
        return  ResponseEntity.ok().body(ClassroomMapper.modelToResponseDto(classroom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        classroomService.delete(id);
        return ResponseEntity.ok().build();
    }
}