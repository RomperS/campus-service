package com.olo.campusservice.infrastructure.adapter;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.model.enums.State;
import com.olo.campusservice.domain.port.outbound.CampusResourceRepository;
import com.olo.campusservice.infrastructure.entity.CampusEntity;
import com.olo.campusservice.infrastructure.entity.CampusResourceEntity;
import com.olo.campusservice.infrastructure.entity.ResourceEntity;
import com.olo.campusservice.infrastructure.mapper.CampusMapper;
import com.olo.campusservice.infrastructure.mapper.CampusResourceMapper;
import com.olo.campusservice.infrastructure.mapper.ResourceMapper;
import com.olo.campusservice.infrastructure.repository.CampusResourceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CampusResourceRepositoryAdapter implements CampusResourceRepository {

    private final CampusResourceJpaRepository campusResourceJpaRepository;

    @Override
    public boolean existsByCampusAndResourceAndState(Campus campus, Resource resource, State state) {
        CampusEntity campusEntity = CampusMapper.modelToEntity(campus);
        ResourceEntity resourceEntity = ResourceMapper.modelToEntity(resource);
        return campusResourceJpaRepository.existsByCampusAndResourceAndState(campusEntity, resourceEntity, state);
    }

    @Override
    public CampusResource save(CampusResource campusResource) {
        CampusResourceEntity entity = CampusResourceMapper.modelToEntity(campusResource);
        return CampusResourceMapper.entityToModel(campusResourceJpaRepository.save(entity));
    }

    @Override
    public List<CampusResource> findAll() {
        return campusResourceJpaRepository.findAll().stream().map(CampusResourceMapper::entityToModel).toList();
    }

    @Override
    public Optional<CampusResource> findById(Long id) {
        return campusResourceJpaRepository.findById(id).map(CampusResourceMapper::entityToModel);
    }

    @Override
    public void delete(Long id) {
        campusResourceJpaRepository.deleteById(id);
    }
}