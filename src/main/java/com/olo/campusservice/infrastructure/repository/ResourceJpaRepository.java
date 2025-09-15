package com.olo.campusservice.infrastructure.repository;

import com.olo.campusservice.infrastructure.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceJpaRepository extends JpaRepository<ResourceEntity, Long> {
    boolean existsByName(String name);

    List<ResourceEntity> findByNameContainingIgnoreCase(String name);

    List<ResourceEntity> findBySupplierContainingIgnoreCase(String supplier);
}
