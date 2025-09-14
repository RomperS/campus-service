package com.olo.campusservice.infrastructure.adapter;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import com.olo.campusservice.infrastructure.entity.CampusEntity;
import com.olo.campusservice.infrastructure.mapper.CampusMapper;
import com.olo.campusservice.infrastructure.repository.CampusJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CampusRepositoryAdapter implements CampusRepository {

    private final CampusJpaRepository campusJpaRepository;


    @Override
    public boolean existsByName(String name) {
        return campusJpaRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        return campusJpaRepository.existsById(id);
    }

    @Override
    public Campus save(Campus campus) {
        CampusEntity campusEntity = CampusMapper.modelToEntity(campus);
        return CampusMapper.entityToModel(campusJpaRepository.save(campusEntity));
    }

    @Override
    public List<Campus> findAll() {
        return campusJpaRepository.findAll().stream().map(CampusMapper::entityToModel).toList();
    }

    @Override
    public Optional<Campus> findById(Long id) {
        return campusJpaRepository.findById(id).map(CampusMapper::entityToModel);
    }

    @Override
    public List<Campus> findByShift(Shift shift) {
        return campusJpaRepository.findByShiftsContaining(shift).stream().map(CampusMapper::entityToModel).toList();
    }

    @Override
    public void delete(Long id) {
        campusJpaRepository.deleteById(id);
    }
}
