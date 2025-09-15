package com.olo.campusservice.infrastructure.adapter;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.Classroom;
import com.olo.campusservice.domain.port.outbound.ClassroomRepository;
import com.olo.campusservice.infrastructure.entity.CampusEntity;
import com.olo.campusservice.infrastructure.entity.ClassroomEntity;
import com.olo.campusservice.infrastructure.mapper.CampusMapper;
import com.olo.campusservice.infrastructure.mapper.ClassroomMapper;
import com.olo.campusservice.infrastructure.repository.ClassroomJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClassroomRepositoryAdapter implements ClassroomRepository {

    private final ClassroomJpaRepository classroomJpaRepository;


    @Override
    public boolean existsByIdentifierInCampus(String identifier, Campus campus) {
        CampusEntity campusEntity = CampusMapper.modelToEntity(campus);
        return classroomJpaRepository.existsByIdentifierAndCampus(identifier, campusEntity);
    }

    @Override
    public Classroom save(Classroom classroom) {
        ClassroomEntity classroomEntity = ClassroomMapper.modelToEntity(classroom);
        return ClassroomMapper.entityToModel(classroomJpaRepository.save(classroomEntity));
    }

    @Override
    public List<Classroom> findAll() {
        return classroomJpaRepository.findAll().stream().map(ClassroomMapper::entityToModel).toList();
    }

    @Override
    public Optional<Classroom> findById(Long id) {
        return classroomJpaRepository.findById(id).map(ClassroomMapper::entityToModel);
    }

    @Override
    public List<Classroom> findByIdentifier(String identifier) {
        return classroomJpaRepository.findByIdentifier(identifier).stream().map(ClassroomMapper::entityToModel).toList();
    }

    @Override
    public List<Classroom> findByCampus(Campus campus) {
        return classroomJpaRepository.findByCampus(CampusMapper.modelToEntity(campus)).stream().map(ClassroomMapper::entityToModel).toList();
    }

    @Override
    public void delete(Long id) {
        classroomJpaRepository.deleteById(id);
    }
}
