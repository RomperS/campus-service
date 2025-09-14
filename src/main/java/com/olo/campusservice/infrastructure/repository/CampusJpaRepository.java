package com.olo.campusservice.infrastructure.repository;

import com.olo.campusservice.domain.model.enums.Shift;
import com.olo.campusservice.infrastructure.entity.CampusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampusJpaRepository extends JpaRepository<CampusEntity, Long> {
    boolean existsByName(String name);

    List<CampusEntity> findByShiftsContaining(Shift shift);
}
