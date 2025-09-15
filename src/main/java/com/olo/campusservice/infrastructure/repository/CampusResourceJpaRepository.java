package com.olo.campusservice.infrastructure.repository;

import com.olo.campusservice.domain.model.enums.State;
import com.olo.campusservice.infrastructure.entity.CampusEntity;
import com.olo.campusservice.infrastructure.entity.CampusResourceEntity;
import com.olo.campusservice.infrastructure.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusResourceJpaRepository extends JpaRepository<CampusResourceEntity, Long> {
    boolean existsByCampusAndResourceAndState(CampusEntity campus, ResourceEntity resource, State state);
}
