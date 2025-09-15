package com.olo.campusservice.infrastructure.adapter;

import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import com.olo.campusservice.infrastructure.entity.ResourceEntity;
import com.olo.campusservice.infrastructure.mapper.ResourceMapper;
import com.olo.campusservice.infrastructure.repository.ResourceJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ResourceRepositoryAdapter implements ResourceRepository {

    private final ResourceJpaRepository resourceJpaRepository;

    @Override
    public boolean existsById(Long id) {
        return resourceJpaRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return resourceJpaRepository.existsByName(name);
    }

    @Override
    public Resource save(Resource resource) {
        ResourceEntity resourceEntity = ResourceMapper.modelToEntity(resource);
        return ResourceMapper.entityToModel(resourceJpaRepository.save(resourceEntity));
    }

    @Override
    public Optional<Resource> findById(Long id) {
        return resourceJpaRepository.findById(id).map(ResourceMapper::entityToModel);
    }

    @Override
    public List<Resource> findByName(String name) {
        return resourceJpaRepository.findByNameContainingIgnoreCase(name).stream().map(ResourceMapper::entityToModel).toList();
    }

    @Override
    public List<Resource> findAll() {
        return resourceJpaRepository.findAll().stream().map(ResourceMapper::entityToModel).toList();
    }

    @Override
    public List<Resource> findBySupplier(String name) {
        return resourceJpaRepository.findBySupplierContainingIgnoreCase(name).stream().map(ResourceMapper::entityToModel).toList();
    }

    @Override
    public void delete(Long id) {
        resourceJpaRepository.deleteById(id);
    }
}
