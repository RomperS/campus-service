package com.olo.campusservice.infrastructure.repository;

import com.olo.campusservice.infrastructure.entity.CampusEntity;
import com.olo.campusservice.infrastructure.entity.ClassroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomJpaRepository extends JpaRepository<ClassroomEntity, Long> {
    boolean existsByIdentifierAndCampus(String identifier, CampusEntity campus);

    List<ClassroomEntity> findByIdentifier(String identifier);
    List<ClassroomEntity> findByCampus(CampusEntity campus);
}
